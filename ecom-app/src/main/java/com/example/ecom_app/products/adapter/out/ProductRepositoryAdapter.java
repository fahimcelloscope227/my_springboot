package com.example.ecom_app.products.adapter.out;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.ecom_app.basic_ecom.domain.dto.Category;
import com.example.ecom_app.products.domain.dto.Product;
import com.example.ecom_app.products.domain.port.out.ProductsRepositoryPort;

@Repository
public class ProductRepositoryAdapter implements ProductsRepositoryPort {

    private final JdbcTemplate jdbcTemplate;

    public ProductRepositoryAdapter(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        String sql = """
                SELECT
                    p.id as p_id, p.name as p_name, p.description as p_description,
                    p.price as p_price, p.stock_quantity as p_stock, p.image_url as p_image,
                    p.is_active as p_active, p.created_at as p_created, p.updated_at as p_updated,
                    c.id as c_id, c.name as c_name, c.description as c_description,
                    c.created_at as c_created, c.updated_at as c_updated
                FROM products p
                LEFT JOIN categories c ON p.category_id = c.id
                """;

        return jdbcTemplate.query(sql, productRowMapper());
    }

    private RowMapper<Product> productRowMapper() {
        return (rs, rowNum) -> {
            Category category = null;
            if (rs.getObject("c_id") != null) {
                category = Category.builder()
                        .id(rs.getLong("c_id"))
                        .name(rs.getString("c_name"))
                        .description(rs.getString("c_description"))
                        .createdAt(rs.getTimestamp("c_created") != null ? rs.getTimestamp("c_created").toLocalDateTime()
                                : null)
                        .updatedAt(rs.getTimestamp("c_updated") != null ? rs.getTimestamp("c_updated").toLocalDateTime()
                                : null)
                        .build();
            }

            return Product.builder()
                    .id(rs.getLong("p_id"))
                    .name(rs.getString("p_name"))
                    .description(rs.getString("p_description"))
                    .price(rs.getBigDecimal("p_price"))
                    .stockQuantity(rs.getInt("p_stock"))
                    .imageUrl(rs.getString("p_image"))
                    .isActive(rs.getBoolean("p_active"))
                    .createdAt(rs.getTimestamp("p_created") != null ? rs.getTimestamp("p_created").toLocalDateTime()
                            : null)
                    .updatedAt(rs.getTimestamp("p_updated") != null ? rs.getTimestamp("p_updated").toLocalDateTime()
                            : null)
                    .category(category)
                    .build();
        };
    }
}

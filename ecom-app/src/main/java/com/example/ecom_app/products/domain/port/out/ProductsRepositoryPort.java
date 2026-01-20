package  com.example.ecom_app.products.domain.port.out;
import java.util.List;

import com.example.ecom_app.products.domain.dto.Product;
 public interface ProductsRepositoryPort {
    
    public List<Product> getAllProducts();

}

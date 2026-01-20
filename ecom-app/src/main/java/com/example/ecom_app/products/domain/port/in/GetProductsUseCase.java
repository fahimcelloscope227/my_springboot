
package com.example.ecom_app.products.domain.port.in;

import java.util.List;

import com.example.ecom_app.products.adapter.dto.ProductResult;
 
  
public interface GetProductsUseCase {
    public List<ProductResult> getAllProducts();
}

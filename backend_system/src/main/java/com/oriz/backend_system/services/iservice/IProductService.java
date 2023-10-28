package com.oriz.backend_system.services.iservice;

import com.oriz.backend_system.exception.ProductException;
import com.oriz.backend_system.model.Product;
import com.oriz.backend_system.requests.CreateProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IProductService {
    public List<Product> findAllProduct();
    public Product createProduct(CreateProductRequest request);
    public String deleteProduct(Long productId) throws ProductException;
    public Product updateProduct(Long productId, Product req) throws  ProductException;
    public Product findProductById(Long id) throws ProductException;
    public List<Product> findProductByCategory(String category);
    public Page<Product> getAllProduct(String category, List<String> colors,List<String> sizes,
                                       Integer minPrice,Integer maxPrice, Integer minDiscount, String sort,
                                       String stock, Integer pageNumber,Integer pageSize);
}

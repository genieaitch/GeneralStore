package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.Product;

import java.util.List;

public interface ProductServie {
    List<Product> findAllProducts();

    List<Product> searchProducts(String keyword);

    Product findProductById(int productId);

    void saveProduct(Product product);
}

package kh.edu.react.provider.service;

import kh.edu.react.provider.dto.Product;
import kh.edu.react.provider.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductServie{

    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Product> findAllProducts() {
        return productMapper.findAllProducts();
    }

    @Override
    public List<Product> searchProducts(String keyword) {
        // keyword = productName or productCategory 가 들어올 수 있는 상태
        return productMapper.searchProducts(keyword);
    }

    @Override
    public Product findProductById(int productId) {
        return productMapper.findProductById(productId);
    }

    @Override
    public void saveProduct(Product product) {
        productMapper.saveProduct(product);
    }
}

package com.mbb.malmobrewbucket.service;

import com.mbb.malmobrewbucket.exception.ProductNotFoundException;
import com.mbb.malmobrewbucket.model.Product;
import com.mbb.malmobrewbucket.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepo productRepo;

    @Autowired
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    public Product addProduct(Product product){
        return productRepo.save(product);
    }

    public List<Product> findAllProducts(){
        return productRepo.findAll();
    }

    public Product updateProduct(Product product){
        return productRepo.save(product);
    }

    public Product findProductById(Long id){
        return productRepo.findProductById(id)
                .orElseThrow(()-> new ProductNotFoundException("Product by id "+id+" not found"));
    }

    public void deleteProduct(Long id){
        productRepo.deleteProductById(id);
    }
}

package com.supera.inovacao.psjava.services;

import com.supera.inovacao.psjava.entities.Product;
import com.supera.inovacao.psjava.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

}

package com.supera.inovacao.psjava.services;

import com.supera.inovacao.psjava.assembler.ProductEntityAssembler;
import com.supera.inovacao.psjava.assembler.ProductInputDisassembler;
import com.supera.inovacao.psjava.dtos.ProductDto;
import com.supera.inovacao.psjava.entities.Product;
import com.supera.inovacao.psjava.exception.ProductNotFoundException;
import com.supera.inovacao.psjava.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductEntityAssembler productEntityAssembler;

    @Transactional
    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product findOrFail(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));
    }

}

package com.supera.inovacao.psjava.controllers;

import com.supera.inovacao.psjava.assembler.ProductEntityAssembler;
import com.supera.inovacao.psjava.assembler.ProductInputDisassembler;
import com.supera.inovacao.psjava.dtos.ProductDto;
import com.supera.inovacao.psjava.dtos.input.ProductDtoInput;
import com.supera.inovacao.psjava.entities.Product;
import com.supera.inovacao.psjava.exception.ProductNotFoundException;
import com.supera.inovacao.psjava.repositories.ProductRepository;
import com.supera.inovacao.psjava.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductEntityAssembler productEntityAssembler;

    @Autowired
    private ProductInputDisassembler productInputDisassembler;

    @GetMapping
    public List<ProductDto> list(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        return productEntityAssembler.toCollectionEntity(products.getContent());
    }

    @GetMapping("/{productId}")
    public ResponseEntity<?> findOne(@PathVariable Long productId) {
        try {
            Product product = productService.findOrFail(productId);
            ProductDto productDto = productEntityAssembler.toEntity(product);
            return ResponseEntity.ok(productDto);
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductDto save(@RequestBody @Valid ProductDtoInput productDtoInput) {
        Product product = productInputDisassembler.toDomainObject(productDtoInput);
        product = productService.save(product);
        return productEntityAssembler.toEntity(product);
    }
}

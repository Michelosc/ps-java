package com.supera.inovacao.psjava.controllers;

import com.supera.inovacao.psjava.assembler.CartEntityAssembler;
import com.supera.inovacao.psjava.assembler.CartInputDisassembler;
import com.supera.inovacao.psjava.dtos.CartDto;
import com.supera.inovacao.psjava.dtos.input.CartDtoInput;
import com.supera.inovacao.psjava.entities.Cart;
import com.supera.inovacao.psjava.entities.Product;
import com.supera.inovacao.psjava.exception.CartNotFoundException;
import com.supera.inovacao.psjava.exception.ProductNotFoundException;
import com.supera.inovacao.psjava.repositories.CartRepository;
import com.supera.inovacao.psjava.services.CartService;
import com.supera.inovacao.psjava.services.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/carrinho")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartInputDisassembler cartInputDisassembler;

    @Autowired
    private CartEntityAssembler cartEntityAssembler;

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<CartDto> list() {
        List<Cart> carts = cartRepository.findAll();

        return cartEntityAssembler.toCollectionEntity(carts);
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<?> findOne(@PathVariable Long cartId) {
        try {
            Cart cart = cartService.findOrFail(cartId);
            CartDto cartDto = cartEntityAssembler.toEntity(cart);
            return ResponseEntity.ok(cartDto);
        } catch (CartNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @Transactional
    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid CartDtoInput cartDtoInput) {
        try {
            Cart cart = new Cart();
            cartDtoInput.getProductIds().stream().forEach(idInput -> {
                Product product = productService.findOrFail(idInput.getProductId());
                cart.addProduct(product);
            });
            cart.checkout();
            cartService.save(cart);
            return ResponseEntity.status(HttpStatus.CREATED).body(cartEntityAssembler.toEntity(cart));
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @PutMapping("/{cartId}")
    @Transactional
    public ResponseEntity<?> addProduct(@PathVariable Long cartId, @RequestBody CartDtoInput cartDtoInput) {
        try {
            Cart cart = cartService.findOrFail(cartId);

            cartDtoInput.getProductIds().stream().forEach(idInput -> {
                Product product = productService.findOrFail(idInput.getProductId());
                cart.addProduct(product);
            });
            cart.checkout();
            cartService.save(cart);
            return ResponseEntity.status(HttpStatus.OK).body(cartEntityAssembler.toEntity(cart));
        } catch (ProductNotFoundException | CartNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }

    @DeleteMapping("/{cartId}")
    @Transactional
    public ResponseEntity<?> removeProduct(@PathVariable Long cartId, @RequestBody CartDtoInput cartDtoInput) {
        try {
            Cart cart = cartService.findOrFail(cartId);
            cartDtoInput.getProductIds().stream().forEach(idInput -> {
                Product product = productService.findOrFail(idInput.getProductId());
                cart.removeProduct(product);
            });
            cart.checkout();
            cartService.save(cart);
            return ResponseEntity.status(HttpStatus.OK).body(cartEntityAssembler.toEntity(cart));
        } catch (ProductNotFoundException | CartNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }

    }
}

package com.supera.inovacao.psjava.services;

import com.supera.inovacao.psjava.entities.Cart;
import com.supera.inovacao.psjava.entities.Product;
import com.supera.inovacao.psjava.exception.CartNotFoundException;
import com.supera.inovacao.psjava.repositories.CartRepository;
import com.supera.inovacao.psjava.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductService productService;

    public Cart checkout(Long cartId) {
        Cart cart = findOrFail(cartId);
        cart.checkout();
        return cart;
    }

    public void addProduct(Long cartId,Product product) {
        Cart cart = findOrFail(cartId);
        Product productFound = productService.findOrFail(product.getId());
        cart.addProduct(productFound);
    }

    public void removeProduct(Long cartId, Product product) {
        Cart cart = findOrFail(cartId);
        Product productFound = productService.findOrFail(product.getId());
        cart.removeProduct(productFound);
    }

    public Cart findOrFail(Long cartId) {
        return cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException(cartId));
    }
}

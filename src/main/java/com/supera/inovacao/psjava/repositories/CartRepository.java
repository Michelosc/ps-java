package com.supera.inovacao.psjava.repositories;

import com.supera.inovacao.psjava.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Long, Cart> {
}

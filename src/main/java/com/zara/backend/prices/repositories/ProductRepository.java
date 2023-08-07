package com.zara.backend.prices.repositories;

import com.zara.backend.prices.model.entities.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
    
}

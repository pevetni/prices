package com.zara.backend.prices.repositories;

import com.zara.backend.prices.model.entities.Price;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository extends CrudRepository<Price, Long> {

}

package com.zara.backend.prices.repositories;

import com.zara.backend.prices.model.entities.Price;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;

public interface PriceRepository extends CrudRepository<Price, Long> {

    @Query("select p from Price p where p.productId = :productId and p.brandId = :brandId and :date between p.startDate and p.endDate order by p.priority desc limit 1")
    Price findByProductIdAndBrandIdAndDateBetweenOrderByPriorityDesc(Long productId, Long brandId, LocalDateTime date);
}

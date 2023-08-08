package com.zara.backend.prices.services;

import com.zara.backend.prices.model.entities.Price;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceService {
    List<Price> findAll();
    Price findByProductIdAndBrandIdAndDateBetweenOrderByPriorityDesc(Long productId, Long brandId, LocalDateTime date);
}

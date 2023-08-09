package com.zara.backend.prices.services;

import com.zara.backend.prices.model.entities.Price;
import com.zara.backend.prices.model.response.PriceResponse;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceService {
    List<Price> findAll();
    PriceResponse findByProductIdAndBrandIdAndDateBetweenOrderByPriorityDesc(Long productId, Long brandId, LocalDateTime date);
}

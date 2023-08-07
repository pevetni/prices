package com.zara.backend.prices.services;

import com.zara.backend.prices.model.entities.Price;

import java.time.LocalDateTime;
import java.util.List;

public interface PriceService {
    List<Price> findAll();
    Price findFirstByDateBetweenOrderByPriorityDesc(LocalDateTime startDate, LocalDateTime endDate);
}

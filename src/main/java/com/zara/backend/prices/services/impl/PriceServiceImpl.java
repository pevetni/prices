package com.zara.backend.prices.services.impl;

import com.zara.backend.prices.model.entities.Price;
import com.zara.backend.prices.repositories.PriceRepository;
import com.zara.backend.prices.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public List<Price> findAll() {
        return (List<Price>) priceRepository.findAll();
    }

    @Override
    public Price findByProductIdAndBrandIdAndDateBetweenOrderByPriorityDesc(Long productId, Long brandId, LocalDateTime date) {
        return priceRepository.findByProductIdAndBrandIdAndDateBetweenOrderByPriorityDesc(productId, brandId, date);
    }
}

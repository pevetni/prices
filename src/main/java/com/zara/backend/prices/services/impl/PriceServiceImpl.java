package com.zara.backend.prices.services.impl;

import com.zara.backend.prices.model.entities.Price;
import com.zara.backend.prices.model.response.PriceResponse;
import com.zara.backend.prices.repositories.PriceRepository;
import com.zara.backend.prices.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    private PriceRepository priceRepository;

    @Override
    public List<Price> findAll() {
        return (List<Price>) priceRepository.findAll();
    }

    @Override
    public PriceResponse findByProductIdAndBrandIdAndDateBetweenOrderByPriorityDesc(Long productId, Long brandId, LocalDateTime date) {
        Price price = priceRepository.findByProductIdAndBrandIdAndDateBetweenOrderByPriorityDesc(productId, brandId, date);
        if (price == null) throw new NoSuchElementException("Price not found for productId = "+productId+", brandId = "+brandId+" and date = "+date.toString());
        return PriceResponse.builder()
                .productId(price.getProductId())
                .brandId(price.getBrandId())
                .priceList(price.getPriceList())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .price(price.getPrice())
                .build();
    }
}

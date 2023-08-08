package com.zara.backend.prices.controllers;

import com.zara.backend.prices.model.entities.Price;
import com.zara.backend.prices.model.request.RequestPrice;
import com.zara.backend.prices.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prices")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @PostMapping("/tariff")
    public ResponseEntity<Price> findCurrentPriceTariff(@RequestBody RequestPrice requestPrice){
        return ResponseEntity.ok(priceService.findByProductIdAndBrandIdAndDateBetweenOrderByPriorityDesc(requestPrice.getProductId(), requestPrice.getBrandId(), requestPrice.getDate()));
    }
}

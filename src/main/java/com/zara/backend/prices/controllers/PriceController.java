package com.zara.backend.prices.controllers;

import com.zara.backend.prices.model.response.PriceResponse;
import com.zara.backend.prices.services.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/prices")
public class PriceController {
    @Autowired
    private PriceService priceService;

    @GetMapping ("/tariff")
    public ResponseEntity<PriceResponse> findCurrentPriceTariff(@RequestParam String productId, String brandId, @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date){
        return ResponseEntity.ok(priceService.findByProductIdAndBrandIdAndDateBetweenOrderByPriorityDesc(Long.valueOf(productId), Long.valueOf(brandId), date));
    }
}

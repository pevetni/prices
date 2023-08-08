package com.zara.backend.prices.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.boot.jackson.JsonComponent;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Entity
@Table(name = "prices")
@Data
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long brandId;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime startDate;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime endDate;

    private Long priceList;

    private Long productId;

    private Long priority;

    private BigDecimal price;

    private Currency currency;

}

package com.zara.backend.prices.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

@Entity
@Table(name = "prices")
@Data
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brand_id")
    private Long id;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    private Long priceList;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private Long priority;

    private BigDecimal price;

    private Currency currency;

}

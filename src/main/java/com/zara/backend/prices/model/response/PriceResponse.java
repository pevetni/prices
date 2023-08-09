package com.zara.backend.prices.model.response;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.zara.backend.prices.utl.LocalDateTimeDeserializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PriceResponse implements Serializable {

    private Long productId;
    private Long brandId;
    private Long priceList;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime startDate;
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime endDate;
    private BigDecimal price;

}

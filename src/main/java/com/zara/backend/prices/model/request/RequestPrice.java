package com.zara.backend.prices.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class RequestPrice implements Serializable {

    private Long productId;
    private LocalDateTime date;
    private Long brandId;

}

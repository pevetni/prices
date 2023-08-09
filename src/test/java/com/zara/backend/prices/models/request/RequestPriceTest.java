package com.zara.backend.prices.models.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RequestPriceTest {
    private Long productId;
    private String date;
    private Long brandId;
    private String expectedResult;
}

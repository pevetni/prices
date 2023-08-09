package com.zara.backend.prices.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.zara.backend.prices.PricesApplication;
import com.zara.backend.prices.model.response.PriceResponse;
import com.zara.backend.prices.models.request.RequestPriceTest;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = PricesApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PriceControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    private List<RequestPriceTest> testCases = new ArrayList<>();

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        //Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        testCases.add(new RequestPriceTest(35455L, "2020-06-14 10:00:00", 1L, "{"
                + "\"productId\": 35455,"
                + "\"brandId\": 1,"
                + "\"priceList\": 1,"
                + "\"startDate\": \"2020-06-14 00:00:00\","
                + "\"endDate\": \"2020-12-31 23:59:59\","
                + "\"price\": 35.50"
                + "}"));
        //Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        testCases.add(new RequestPriceTest(35455L, "2020-06-14 16:00:00", 1L, "{"
                + "\"productId\": 35455,"
                + "\"brandId\": 1,"
                + "\"priceList\": 2,"
                + "\"startDate\": \"2020-06-14 15:00:00\","
                + "\"endDate\": \"2020-06-14 18:30:00\","
                + "\"price\": 25.45"
                + "}"));
        //Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
        testCases.add(new RequestPriceTest(35455L, "2020-06-14 21:00:00", 1L, "{"
                + "\"productId\": 35455,"
                + "\"brandId\": 1,"
                + "\"priceList\": 1,"
                + "\"startDate\": \"2020-06-14 00:00:00\","
                + "\"endDate\": \"2020-12-31 23:59:59\","
                + "\"price\": 35.50"
                + "}"));
        //Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
        testCases.add(new RequestPriceTest(35455L, "2020-06-15 10:00:00", 1L, "{"
                + "\"productId\": 35455,"
                + "\"brandId\": 1,"
                + "\"priceList\": 3,"
                + "\"startDate\": \"2020-06-15 00:00:00\","
                + "\"endDate\": \"2020-06-15 11:00:00\","
                + "\"price\": 30.50"
                + "}"));
        //Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
        testCases.add(new RequestPriceTest(35455L, "2020-06-16 21:00:00", 1L, "{"
                + "\"productId\": 35455,"
                + "\"brandId\": 1,"
                + "\"priceList\": 4,"
                + "\"startDate\": \"2020-06-15 16:00:00\","
                + "\"endDate\": \"2020-12-31 23:59:59\","
                + "\"price\": 38.95"
                + "}"));
    }

    @DisplayName("Find current price")
    @RepeatedTest(value = 5, name = "{displayName} - Repetition number {currentRepetition} of {totalRepetitions}")
    void findCurrentPriceTariff(RepetitionInfo info) throws Exception {
        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        String params = "?productId="+ testCases.get(info.getCurrentRepetition()-1).getProductId() +
        "&brandId=" + testCases.get(info.getCurrentRepetition()-1).getBrandId()+
        "&date=" + testCases.get(info.getCurrentRepetition()-1).getDate().toString();


        ResponseEntity<PriceResponse> response = restTemplate.exchange(
                createURL("/prices/tariff" + params),
                HttpMethod.GET, entity, PriceResponse.class);

        String expected = testCases.get(info.getCurrentRepetition()-1).getExpectedResult();

        JSONAssert.assertEquals(expected, convertToJson(response.getBody()), false);
    }

    private String createURL(String uri) {
        return "http://localhost:" + port + uri;
    }

    private String convertToJson(PriceResponse response) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(response);
            System.out.println("JSON representation: " + json);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }
}
package com.ivanskyi.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ShoppingController {

    private final RestTemplate restTemplate;

    @Autowired
    public ShoppingController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/payment/{price}")
    public String invokePaymentService(@PathVariable int price) {
        String url = String.format("http://PAYMENT/payment-provider/payNow/%d", price);
        return restTemplate.getForObject(url, String.class);
    }
}

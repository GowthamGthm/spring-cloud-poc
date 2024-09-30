package com.gthm.shipping_service.controller;

import com.gthm.shipping_service.controller.service.ShippingService;
import com.gthm.shipping_service.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShippingController {

    @Autowired
    ShippingService  shippingService;

    @PostMapping("/shipping")
    public ResponseEntity<Order> processShipping(@RequestBody Order order) {

        order = shippingService.processShipping(order);
        return ResponseEntity.status(HttpStatus.OK).body(order);

    }

    @GetMapping("/shipping")
    public ResponseEntity<List<Order>> getALlOrders() {

        List<Order> aLlOrders = shippingService.getALlOrders();
        return ResponseEntity.status(HttpStatus.OK).body(aLlOrders);

    }


}
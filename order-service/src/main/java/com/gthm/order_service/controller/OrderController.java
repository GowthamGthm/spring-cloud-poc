package com.gthm.order_service.controller;



import com.gthm.order_service.model.Order;
import com.gthm.order_service.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Order> makeOrder(@RequestBody Order order) {

        order = orderService.makeOrder(order);
        return ResponseEntity.status(HttpStatus.OK).body(order);

    }

    @GetMapping("/order")
    public ResponseEntity<List<Order>> getALlOrders() {
        List<Order> allOrders = orderService.getAllOrders();
        return ResponseEntity.status(HttpStatus.OK).body(allOrders);
    }

}
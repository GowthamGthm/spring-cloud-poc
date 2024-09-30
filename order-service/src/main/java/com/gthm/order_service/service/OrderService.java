package com.gthm.order_service.service;


import com.gthm.order_service.clients.ShippingClient;
import com.gthm.order_service.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    List<Order> ORDER_LIST = new ArrayList<>();

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ShippingClient shippingClient;

    public Order makeOrder(Order order) {
        order.setOrderID(ORDER_LIST.size() + 1);

        order = makeShipping(order);
        ORDER_LIST.add(order);
        return order;
    }

    private Order makeShipping(Order order) {
//        String url = "http://localhost:9092/shipping";
        String url = "http://SHIPPING-SERVICE:9092/shipping";

//         Using rest template
        ResponseEntity<Order> orderResponseEntity = restTemplate.postForEntity(url, order, Order.class);
        return orderResponseEntity.getBody();

//        USING Open feign client
//        order = shippingClient.postShipping(order);
//        return order;
    }


    public List<Order> getAllOrders() {
        return ORDER_LIST;
    }
}
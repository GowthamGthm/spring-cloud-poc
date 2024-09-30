package com.gthm.shipping_service.controller.service;


import com.gthm.shipping_service.model.Order;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShippingService {

    List<Order>  ORDER_LIST = new ArrayList<>();

    public Order processShipping(Order order) {
        order.setStatus("SHIPPED");
        ORDER_LIST.add(order);
        return order;
    }

    public List<Order> getALlOrders() {
        return ORDER_LIST;
    }

}
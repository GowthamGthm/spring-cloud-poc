package com.gthm.order_service.clients;


import com.gthm.order_service.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("http://SHIPPING-SERVICE:9092")
public interface ShippingClient {


    @PostMapping("/shipping")
    public Order postShipping(@RequestBody Order order);


}
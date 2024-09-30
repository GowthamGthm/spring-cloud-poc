package com.gthm.shipping_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Integer orderID;
    private String productName;
    private String orderedDate;

    private String status;


}
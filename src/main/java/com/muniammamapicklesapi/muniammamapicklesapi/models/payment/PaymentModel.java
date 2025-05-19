package com.muniammamapicklesapi.muniammamapicklesapi.models.payment;

import java.time.Instant;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

public class PaymentModel {
    private Object data;
    private String orderId;
    private long amount;
    private String orderReceipt;
    private String status;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

}

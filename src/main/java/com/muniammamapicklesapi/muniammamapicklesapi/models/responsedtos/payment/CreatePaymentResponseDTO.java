package com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.payment;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentResponseDTO {

    private Object data;
    private String orderId;
    private int amount;
    private Date createdAt;
    private String orderReceipt;
    private String status;

}

package com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentResponseDTO {

    private Object data;
    private String orderId;
    private long amount;
    private String createdAt;
    private String orderReceipt;
    private String status;

}

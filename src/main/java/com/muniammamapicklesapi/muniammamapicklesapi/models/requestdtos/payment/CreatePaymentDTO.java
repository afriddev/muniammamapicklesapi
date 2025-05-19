package com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePaymentDTO {

    private String emailId;
    private Integer amount;

}

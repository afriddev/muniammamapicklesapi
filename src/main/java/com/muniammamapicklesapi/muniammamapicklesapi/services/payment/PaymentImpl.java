package com.muniammamapicklesapi.muniammamapicklesapi.services.payment;

import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.payment.ConfirmPaymentRequestDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.payment.CreatePaymentDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.payment.ConfirmPaymentResponseDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.payment.CreatePaymentResponseDTO;

public interface PaymentImpl {

    CreatePaymentResponseDTO createPayment(CreatePaymentDTO request);

    ConfirmPaymentResponseDTO confirmPayemnt(ConfirmPaymentRequestDTO request);

}

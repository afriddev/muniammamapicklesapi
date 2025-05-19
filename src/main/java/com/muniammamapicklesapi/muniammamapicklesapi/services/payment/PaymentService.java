package com.muniammamapicklesapi.muniammamapicklesapi.services.payment;

import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.payment.CreatePaymentDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.payment.CreatePaymentResponseDTO;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.bson.json.JsonObject;


public class PaymentService implements PaymentImpl {

    @Override
    public CreatePaymentResponseDTO createPayment(CreatePaymentDTO request) {
RazorpayClient razorpay = new RazorpayClient("rzp_live_CpXLAO0ri39J18", "AIfH9G9L1dL3hGoJyr5TrXwT");
            JsonObject orderRequest = new JsonObject(null);



    }

     

}

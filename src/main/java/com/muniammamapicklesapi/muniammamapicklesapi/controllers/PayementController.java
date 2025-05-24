package com.muniammamapicklesapi.muniammamapicklesapi.controllers;

import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.payment.ConfirmPaymentRequestDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.payment.CreatePaymentDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.payment.ConfirmPaymentResponseDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.payment.CreatePaymentResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.muniammamapicklesapi.muniammamapicklesapi.services.payment.PaymentService;

@RestController
@RequestMapping("/api/order")
public class PayementController {

    PaymentService paymentService;

    // @PostMapping("/create")
    // public String createOrder(@RequestParam int amount) {
    // try {
    // RazorpayClient razorpay = new RazorpayClient("rzp_live_CpXLAO0ri39J18",
    // "AIfH9G9L1dL3hGoJyr5TrXwT");

    // JSONObject orderRequest = new JSONObject();
    // orderRequest.put("amount", amount * 100); // amount in paise
    // orderRequest.put("currency", "INR");
    // orderRequest.put("receipt", "order_rcptid_11");
    // orderRequest.put("payment_capture", true);

    // Order order = razorpay.orders.create(orderRequest);
    // return order.toString(); // You can return order.get("id") if you just want
    // } catch (Exception e) {
    // e.printStackTrace();
    // return "{\"error\": \"Order creation failed\"}";
    // }
    // }

    @PostMapping("/create")
    public CreatePaymentResponseDTO createPaymentOrder(@RequestBody CreatePaymentDTO request) {

        PaymentService paymentService = new PaymentService();

        return paymentService.createPayment(request);

    }

    @PostMapping("/verify")
    public ConfirmPaymentResponseDTO createPaymentOrder(@RequestBody ConfirmPaymentRequestDTO request) {

        PaymentService paymentService = new PaymentService();

        return paymentService.confirmPayemnt(request);

    }

}

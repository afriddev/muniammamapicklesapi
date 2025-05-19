package com.muniammamapicklesapi.muniammamapicklesapi.controllers;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class PayementController {

    @PostMapping("/create")
    public String createOrder(@RequestParam int amount) {
        try {
            RazorpayClient razorpay = new RazorpayClient("rzp_live_CpXLAO0ri39J18", "AIfH9G9L1dL3hGoJyr5TrXwT");

            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", amount * 100); // amount in paise
            orderRequest.put("currency", "INR");
            orderRequest.put("receipt", "order_rcptid_11");
            orderRequest.put("payment_capture", true);

            Order order = razorpay.orders.create(orderRequest);
            return order.toString(); // You can return order.get("id") if you just want the order_id
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"error\": \"Order creation failed\"}";
        }
    }

}

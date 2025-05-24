package com.muniammamapicklesapi.muniammamapicklesapi.services.payment;

import com.muniammamapicklesapi.muniammamapicklesapi.enums.response.ResponseEnums;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.payment.ConfirmPaymentRequestDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.requestdtos.payment.CreatePaymentDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.payment.ConfirmPaymentResponseDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.models.responsedtos.payment.CreatePaymentResponseDTO;
import com.muniammamapicklesapi.muniammamapicklesapi.utils.AuthUtils;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;

import com.razorpay.Utils;

import io.github.cdimascio.dotenv.Dotenv;

import org.json.JSONObject;

public class PaymentService implements PaymentImpl {
    AuthUtils authUtils = new AuthUtils();
    private static final Dotenv dotenv = Dotenv.load();
    private String keyId = dotenv.get("RAZORPAY_KEY_ID");
    private String keySecret = dotenv.get("RAZORPAY_KEY_SECRET");

    @Override
    public CreatePaymentResponseDTO createPayment(CreatePaymentDTO request) {
        CreatePaymentResponseDTO response = new CreatePaymentResponseDTO();
        try {
            RazorpayClient razorpay = new RazorpayClient(keyId, keySecret);
            JSONObject orderRequest = new JSONObject();
            orderRequest.put("amount", request.getAmount() * 100); // amount in paise
            orderRequest.put("currency", "INR");
            orderRequest.put("receipt", authUtils.generateReceiptId());
            orderRequest.put("payment_capture", true);

            Order order = razorpay.orders.create(orderRequest);
            response.setOrderId(order.get(("id")));
            response.setAmount(order.get(("amount")));
            response.setCreatedAt((order.get(("created_at"))));
            response.setStatus(order.get(("created")));
            response.setOrderReceipt(order.get("receipt"));
            response.setData(ResponseEnums.SUCCESS);
            return response;

        } catch (Exception e) {
            response.setData(ResponseEnums.INTERNAL_SERVER_ERROR);
            return response;
        }

    }

    public ConfirmPaymentResponseDTO confirmPayemnt(ConfirmPaymentRequestDTO request) {

        ConfirmPaymentResponseDTO response = new ConfirmPaymentResponseDTO();

        JSONObject attributes = new JSONObject();
        attributes.put("razorpay_order_id", request.getRazorpayOrderId());
        attributes.put("razorpay_payment_id", request.getRazorpayPaymentId());
        attributes.put("razorpay_signature", request.getRazorpaySignature());

        try {
            boolean verify = Utils.verifyPaymentSignature(attributes, keySecret);
            if (verify) {
                response.setData(ResponseEnums.SUCCESS);
            } else {
                response.setData((ResponseEnums.INVALID_PAYMENT));
            }

            return response;

        } catch (Exception e) {
            System.out.println(e);
            response.setData(ResponseEnums.INTERNAL_SERVER_ERROR);

            return response;
        }

    }

}

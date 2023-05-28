package com.productorderservice.poAPI.payment;

import com.productorderservice.poAPI.order.Order;

class PaymentService {
    private final PaymentServiceTest paymentServiceTest;
    private PaymentPort paymentPort;

    PaymentService(PaymentServiceTest paymentServiceTest, final PaymentPort paymentPort) {
        this.paymentServiceTest = paymentServiceTest;
        this.paymentPort = paymentPort;
    }

    public void payment(PaymentRequest request) {
        Order order = paymentPort.getOrder(request.getOrderId());
        final Payment payment = new Payment(order, request.getCardNumber());
        paymentPort.pay(payment.getPrice(),payment.getCardNumber());
        paymentPort.save(payment);
    }
}

package com.productorderservice.poAPI.payment;

import com.productorderservice.poAPI.order.Order;
import org.springframework.stereotype.Component;

@Component
class PaymentService {

    private PaymentPort paymentPort;

    PaymentService(final PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    public void payment(PaymentRequest request) {
        Order order = paymentPort.getOrder(request.getOrderId());
        final Payment payment = new Payment(order, request.getCardNumber());
        paymentPort.pay(payment.getPrice(),payment.getCardNumber());
        paymentPort.save(payment);
    }
}

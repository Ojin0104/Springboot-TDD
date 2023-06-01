package com.productorderservice.poAPI.payment;

import com.productorderservice.poAPI.order.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@RequestMapping("/payments")
class PaymentService {

    private PaymentPort paymentPort;

    PaymentService(final PaymentPort paymentPort) {
        this.paymentPort = paymentPort;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Void> payment(@RequestBody PaymentRequest request) {
        Order order = paymentPort.getOrder(request.getOrderId());

        final Payment payment = new Payment(order, request.getCardNumber());

        paymentPort.pay(payment.getPrice(),payment.getCardNumber());

        paymentPort.save(payment);

        return ResponseEntity.status(HttpStatus.OK).build();
    }
}

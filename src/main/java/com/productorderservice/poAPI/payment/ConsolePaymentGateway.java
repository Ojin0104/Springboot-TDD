package com.productorderservice.poAPI.payment;

import org.springframework.stereotype.Component;

@Component
public class ConsolePaymentGateway implements PaymentGateway {


    @Override
    public void execute(int totalPrice, String cardNumber) {
        System.out.println("결졔완료");

    }
}

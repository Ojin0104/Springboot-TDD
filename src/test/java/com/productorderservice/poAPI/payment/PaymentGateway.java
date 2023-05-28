package com.productorderservice.poAPI.payment;

interface PaymentGateway {

    void execute(int totalPrice, String cardNumber);
}

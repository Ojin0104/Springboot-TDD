package com.productorderservice.poAPI.payment;

import com.productorderservice.poAPI.order.Order;

interface PaymentPort {
    public Order getOrder(Long orderId);

    public void pay(int totalPrice, String cardNumber );

    public void save(Payment payment);
}

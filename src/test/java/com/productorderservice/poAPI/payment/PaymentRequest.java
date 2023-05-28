package com.productorderservice.poAPI.payment;

import org.springframework.util.Assert;

class PaymentRequest {
    Long orderId;
    String cardNumber;

    public PaymentRequest(final Long orderId, final String cardNumber) {

        Assert.notNull(orderId, "주문  ID는 필수입니다.");
        Assert.hasText(cardNumber, "카드 번호는 필수입니다.");
        this.orderId = orderId;
        this.cardNumber = cardNumber;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public String getCardNumber() {
        return this.cardNumber;
    }
}

package com.productorderservice.poAPI.payment;

import com.productorderservice.poAPI.order.Order;
import org.springframework.util.Assert;

class Payment {
    private Order order;
    private Long id;
    private String cardNumber;

    public Order getOrder() {
        return order;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Long getId() {
        return id;
    }

    public Payment(final Order order, final String cardNumber) {
        Assert.notNull(order, "주문의 필수입니다");
        Assert.hasText(cardNumber, "카드 번호는 필수입니다.");
        this.order = order;
        this.cardNumber = cardNumber;
    }

    public void assignId(final Long id) {
        this.id = id;
    }

    public int getPrice() {
        return order.getTotalPrice();
    }


}

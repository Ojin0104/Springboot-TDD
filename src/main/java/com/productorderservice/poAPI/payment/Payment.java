package com.productorderservice.poAPI.payment;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.productorderservice.poAPI.order.Order;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
class Payment {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Order order;

    private String cardNumber;

    public int getPrice(){
        return this.order.getTotalPrice();
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



}

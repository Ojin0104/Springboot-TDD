package com.productorderservice.poAPI.product;

import org.springframework.util.Assert;

class UpdateProductRequest {
    private final String name;
    private final int price;
    private final DiscountPolicy discountPolicy;

    public UpdateProductRequest(final String name, final int price, final DiscountPolicy discountPolicy) {
        Assert.hasText(name, "상품명은 필수입니다.");
        Assert.isTrue(price > 0, "상품가격은 0보다 커야합니다.");
        Assert.notNull(discountPolicy, "할인정책 필수입니다");
        this.name = name;
        this.price = price;
        this.discountPolicy = discountPolicy;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public DiscountPolicy getDiscountPolicy() {
        return discountPolicy;
    }
}

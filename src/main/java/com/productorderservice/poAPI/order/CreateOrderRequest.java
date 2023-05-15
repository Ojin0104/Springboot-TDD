package com.productorderservice.poAPI.order;

import org.springframework.util.Assert;

class CreateOrderRequest {
    public Long productId;
    public int quantity;

    public CreateOrderRequest(final Long productId, final int quantity) {
        Assert.notNull(productId, "상품 Id는 필수입니다");
        Assert.isTrue(quantity > 0, " 수량은 0보다 커야합니다");
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long productId() {
        return this.productId;
    }

    public int quantity() {
        return this.quantity;
    }

}

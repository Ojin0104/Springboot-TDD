package com.productorderservice.poAPI.order;

import com.productorderservice.poAPI.product.Product;
import org.springframework.util.Assert;

class Order {
    private final Product product;
    private Long id;
    private final int quantity;

    public Order(Product product, final int quantity) {
        Assert.notNull(product, "상품은 필수입니다.");
        Assert.isTrue(quantity > 0, "수량은 0보다 큽니다");
        this.product = product;
        this.quantity = quantity;
    }

    public void assignId(final Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }
}

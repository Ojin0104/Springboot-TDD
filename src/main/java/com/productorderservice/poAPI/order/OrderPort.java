package com.productorderservice.poAPI.order;

import com.productorderservice.poAPI.product.Product;

interface OrderPort {
    Product getProductById(final Long ProductId);

    void save(final Order order);
}

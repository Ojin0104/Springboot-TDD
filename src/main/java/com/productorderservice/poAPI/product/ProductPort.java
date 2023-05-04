package com.productorderservice.poAPI.product;

interface ProductPort {

    public void save(final Product product);
    public Product getProduct(final Long productId);
}

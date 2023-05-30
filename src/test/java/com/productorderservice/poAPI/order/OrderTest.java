package com.productorderservice.poAPI.order;

import com.productorderservice.poAPI.product.DiscountPolicy;
import com.productorderservice.poAPI.product.Product;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderTest {

    @Test
    void getTotalPrice(){
        final Order order=new Order(new Product("상품명", 1000, DiscountPolicy.NONE),2);
        final int totalPrice=order.getTotalPrice();

        assertThat(totalPrice).isEqualTo(2000);
    }
}

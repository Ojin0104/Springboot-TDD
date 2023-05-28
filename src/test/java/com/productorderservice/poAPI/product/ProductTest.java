package com.productorderservice.poAPI.product;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ProductTest {

    @Test
    void update(){
        final Product product=new Product("상품명", 1000,DiscountPolicy.NONE);

        product.update("상품 수정", 2000, DiscountPolicy.NONE);

        assertThat(product.getName()).isEqualTo("상품 수정");
        assertThat(product.getPrice()).isEqualTo(2000);

    }

    @Test
    void none_discounted_product(){
        final int price=1000;
        final int discountedPrice=DiscountPolicy.NONE.applyDiscount(price);


        assertThat(discountedPrice).isEqualTo(1000);

    }

    @Test
    void fix_1000_discounted_product(){
        final int price=2000;
        final int discountedPrice=DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);


        assertThat(discountedPrice).isEqualTo(1000);

    }
    @Test
    void over_1000_discounted_product(){
        final int price=500;
        final int discountedPrice=DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price);


        assertThat(discountedPrice).isEqualTo(0);

    }
}

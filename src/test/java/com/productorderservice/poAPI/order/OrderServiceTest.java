package com.productorderservice.poAPI.order;

import com.productorderservice.poAPI.product.DiscountPolicy;
import com.productorderservice.poAPI.product.Product;

import com.productorderservice.poAPI.product.ProductService;
import com.productorderservice.poAPI.product.ProductSteps;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;



    @Test
    void 상품주문(){
        productService.addProduct(ProductSteps.상품등록요청_생성());
        final CreateOrderRequest request= 상품주문요청_생성();

        orderService.createOrder(request);
    }

    private CreateOrderRequest 상품주문요청_생성() {
        final Long productId =1L;
        final int quantity =2;
        final CreateOrderRequest request=new CreateOrderRequest(productId, quantity);
        return request;
    }

}

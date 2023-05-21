package com.productorderservice.poAPI.order;

import com.productorderservice.poAPI.ApiTest;

import com.productorderservice.poAPI.product.ProductService;
import com.productorderservice.poAPI.product.ProductSteps;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class OrderApiTest extends ApiTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;



    @Test
    void 상품주문(){
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final CreateOrderRequest request= OrderSteps.상품주문요청_생성();

        final ExtractableResponse<Response> response= OrderSteps.상품주문요청(request);


        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }



}

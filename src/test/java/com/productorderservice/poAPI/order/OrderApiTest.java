package com.productorderservice.poAPI.order;

import com.productorderservice.poAPI.ApiTest;

import com.productorderservice.poAPI.product.ProductService;
import com.productorderservice.poAPI.product.ProductSteps;
import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class OrderApiTest extends ApiTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;



    @Test
    void 상품주문(){
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성());
        final CreateOrderRequest request= 상품주문요청_생성();

        final ExtractableResponse<Response> response= RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/order")
                .then()
                .log().all().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value());
    }

    private CreateOrderRequest 상품주문요청_생성() {
        final Long productId =1L;
        final int quantity =2;
        final CreateOrderRequest request=new CreateOrderRequest(productId, quantity);
        return request;
    }

}

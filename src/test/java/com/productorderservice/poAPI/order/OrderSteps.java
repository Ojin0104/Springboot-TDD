package com.productorderservice.poAPI.order;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.springframework.http.MediaType;

public class OrderSteps {
    static ExtractableResponse<Response> 상품주문요청(final CreateOrderRequest request) {
        final ExtractableResponse<Response> response = RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .when()
                .post("/order")
                .then()
                .log().all().extract();
        return response;


    }

    static CreateOrderRequest 상품주문요청_생성() {
        final Long productId =1L;
        final int quantity =2;
        final CreateOrderRequest request=new CreateOrderRequest(productId, quantity);
        return request;
    }
}

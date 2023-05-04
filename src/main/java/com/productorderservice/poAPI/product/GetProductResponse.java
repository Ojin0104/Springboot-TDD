package com.productorderservice.poAPI.product;

class GetProductResponse {

    long id;
    String name;
    int price;
    DiscountPolicy diconutpolicy;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public DiscountPolicy getDiconutpolicy() {
        return diconutpolicy;
    }

    public void setDiconutpolicy(DiscountPolicy diconutpolicy) {
        this.diconutpolicy = diconutpolicy;
    }

    GetProductResponse(long id, String name, int price, DiscountPolicy discountPolicy) {
        {
           // AssertnotNull(id, "상품 ID는 필수입니다.");

            this.id = id;
            this.name = name;
            this.price = price;
            this.diconutpolicy = discountPolicy;
        }
    }
}

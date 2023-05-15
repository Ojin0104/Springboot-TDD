package com.productorderservice.poAPI.order;

import com.productorderservice.poAPI.product.Product;
import com.productorderservice.poAPI.product.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class OrderServiceTest {

    private OrderService orderService;
    private OrderPort orderPort;
    private OrderRepository orderRepository;


    @BeforeEach
    void setUp(){
        orderRepository=new OrderRepository();
        orderPort=new OrderPort(null,null);
        orderService = new OrderService(orderPort);
    }
    @Test
    void 상품주문(){
        final Long productId =1L;
        final int quantity =2;
        final CreateOrderRequest request=new CreateOrderRequest(productId, quantity);

        orderService.createOrder(request);
    }

    private class CreateOrderRequest {
        public Long productId;
        public int quantity;

        public CreateOrderRequest(final Long productId,final int quantity){
            Assert.notNull(productId, "상품 Id는 필수입니다");
            Assert.isTrue(quantity>0, " 수량은 0보다 커야합니다");
            this.productId=productId;
            this.quantity=quantity;
        }
    }

    private class OrderService {

        private final orderPort orderPort;

        private OrderService(final OrderPort orderPort){
            this.orderPort=orderPort;
        }
        public void createOrder(CreateOrderRequest request) {
            final Product product=orderPort.getProductById(request.productId());

            final Order order= new Order(product,request.quantity());

            orderPort.save(order);
        }
    }

    private class OrderAdapter {
        private final ProductRepository productRepository;
        private final OrderRepository orderRepository;



        private OrderAdapter(ProductRepository productRepository, OrderRepository orderRepository) {
            this.productRepository = productRepository;
            this.orderRepository = orderRepository;
        }

        public Product getProductById(final Long productId){
            return productRepository.findById(productId)
                    .orElseThrow();
        }

        public void save(final Order order){
            orderRepository.save(order);
        }
    }

    private class Order {
        private final Product product;
        private Long id;
        private final int quantity;
        public Order(Product product, final int quantity) {
            Assert.notNull(product,"상품은 필수입니다.");
            Assert.isTrue(quantity>0,"수량은 0보다 큽니다");
            this.product=product;
            this.quantity=quantity;
        }

        public void assignId(final Long id) {
            this.id=id;
        }

        public Long getId() {
            return this.id;
        }
    }

    private class OrderRepository {
        
        private Map<Long,Order> persistence=new HashMap<>();
        private Long sequence =0L;

        public void save(Order order) {
            order.assignId(++sequence);
            persistence.put(order.getId(),order);
        }
    }
}

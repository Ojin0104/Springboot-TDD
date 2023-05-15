package com.productorderservice.poAPI.order;

import com.productorderservice.poAPI.product.Product;
import com.productorderservice.poAPI.product.ProductRepository;
import org.springframework.stereotype.Component;

@Component
class OrderAdapter implements OrderPort {
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;


    private OrderAdapter(ProductRepository productRepository, OrderRepository orderRepository) {
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
    }

    public Product getProductById(final Long productId) {
        return productRepository.findById(productId)
                .orElseThrow();
    }

    public void save(final Order order) {
        orderRepository.save(order);
    }
}

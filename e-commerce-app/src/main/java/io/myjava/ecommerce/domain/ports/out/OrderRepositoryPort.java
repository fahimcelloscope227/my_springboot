package io.myjava.ecommerce.domain.ports.out;

public interface OrderRepositoryPort {

    void saveOrder(FoodOrder order);

    String findOrderById(String orderId);

}

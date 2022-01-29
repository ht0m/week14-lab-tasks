package day01;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderService {

    private List<Order> orders = new ArrayList<>();


    public void saveOrder(Order order) {
        orders.add(order);
    }

    public long getNumberOfOrdersWithStatus(String s) {
        return orders.stream()
                .filter(o -> o.getStatus().equals(s))
                .count();
    }

    public List<Order> getOrdersBetweenDates(LocalDate date1, LocalDate date2) {
        return orders.stream()
                .filter(o -> o.getOrderDate().isAfter(date1) && o.getOrderDate().isBefore(date2))
                .collect(Collectors.toList());
    }

    public boolean IsLessProductThan(int number) {
        return orders.stream()
                .anyMatch(o -> o.getProducts().size() < number);
    }

    public Order getOrderWithMaxNumberOfProducts() {
        return orders.stream()
                .max(Comparator.comparing(order -> order.getProducts().size()))
                .orElseThrow(() -> new IllegalStateException("Empty"));
    }

    public List<Order> getOrdersWithCategory(String s) {
        return orders.stream()
                .filter(o -> o.getProducts().stream().anyMatch(p -> p.getCategory().equals(s))).toList();
    }
}





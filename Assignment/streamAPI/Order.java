import java.util.*;
import java.util.stream.*;

class Order {
    private int orderId;
    private String customerName;
    private String city;
    private double amount;
    private int itemCount;
    private String status;

    public Order(int orderId, String customerName, String city, double amount, int itemCount, String status) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.city = city;
        this.amount = amount;
        this.itemCount = itemCount;
        this.status = status;
    }

    public int getOrderId() { return orderId; }
    public String getCustomerName() { return customerName; }
    public String getCity() { return city; }
    public double getAmount() { return amount; }
    public int getItemCount() { return itemCount; }
    public String getStatus() { return status; }
}

public class OrderTasks {

    // ----------------- TASK 10 -----------------
    public static List<String> task10(List<Order> orders) {
        return orders.stream()
                .filter(o -> !(o.getCity().equalsIgnoreCase("Bangalore") 
                               && o.getAmount() > 7000 
                               && o.getItemCount() < 5))
                .sorted(Comparator.comparingDouble(Order::getAmount).reversed()
                        .thenComparing(Order::getCustomerName))
                .map(o -> o.getCustomerName().toUpperCase())
                .collect(Collectors.toList());
    }

    // ----------------- TASK 11 -----------------
    public static List<String> task11(List<Order> orders) {
        return orders.stream()
                .filter(o -> !(o.getStatus().equalsIgnoreCase("Pending") 
                               && o.getAmount() >= 2000 
                               && o.getAmount() <= 9000 
                               && o.getCity().endsWith("i")))
                .sorted(Comparator.comparingInt(Order::getItemCount)
                        .thenComparing(Comparator.comparingDouble(Order::getAmount).reversed()))
                .map(o -> String.valueOf(o.getOrderId()))
                .collect(Collectors.toList());
    }

    // ----------------- TASK 12 -----------------
    public static List<String> task12(List<Order> orders) {
        return orders.stream()
                .filter(o -> !(o.getCustomerName().length() > 5 
                               && o.getAmount() < 5000 
                               && o.getItemCount() > 2))
                .sorted(Comparator.comparing(Order::getCity).reversed()
                        .thenComparingDouble(Order::getAmount))
                .map(o -> new StringBuilder(o.getCustomerName()).reverse().toString())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(101, "Alice", "Bangalore", 8000, 3, "Delivered"));
        orders.add(new Order(102, "Bob", "Mumbai", 5000, 6, "Pending"));
        orders.add(new Order(103, "Charlie", "Delhi", 9000, 5, "Delivered"));
        orders.add(new Order(104, "David", "Kolkata", 4000, 4, "Pending"));
        orders.add(new Order(105, "Eve", "Chennai", 12000, 2, "Delivered"));
        orders.add(new Order(106, "Frank", "Bhopal", 3000, 3, "Pending"));

        List<String> task10Result = task10(orders);
        List<String> task11Result = task11(orders);
        List<String> task12Result = task12(orders);

        System.out.println("-------- TASK 10 RESULT --------");
        task10Result.forEach(System.out::println);

        System.out.println("\n-------- TASK 11 RESULT --------");
        task11Result.forEach(System.out::println);

        System.out.println("\n-------- TASK 12 RESULT --------");
        task12Result.forEach(System.out::println);
    }
}

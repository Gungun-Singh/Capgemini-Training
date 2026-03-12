import java.util.*;
import java.util.stream.*;

class Product {
    private int id;
    private String name;
    private String category;
    private double price;
    private int quantity;
    private double rating;

    public Product(int id, String name, String category, double price, int quantity, double rating) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.rating = rating;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }
    public double getRating() { return rating; }
}

public class ProductTasks {

    // ----------------- TASK 7 -----------------
    public static List<String> task7(List<Product> products) {
        return products.stream()
                .filter(p -> !(p.getCategory().equalsIgnoreCase("Electronics") 
                               && p.getPrice() > 15000 
                               && p.getQuantity() < 30))
                .sorted(Comparator.comparingDouble(Product::getRating).reversed()
                        .thenComparingDouble(Product::getPrice))
                .map(p -> p.getName().toUpperCase())
                .collect(Collectors.toList());
    }

    // ----------------- TASK 8 -----------------
    public static List<Integer> task8(List<Product> products) {
        return products.stream()
                .filter(p -> !(p.getCategory().length() > 6 
                               && p.getPrice() >= 2000 
                               && p.getPrice() <= 10000 
                               && p.getRating() < 3.5))
                .sorted(Comparator.comparingInt(Product::getQuantity)
                        .thenComparing(Comparator.comparingDouble(Product::getRating).reversed()))
                .map(p -> p.getId() * 3)
                .collect(Collectors.toList());
    }

    // ----------------- TASK 9 -----------------
    public static List<String> task9(List<Product> products) {
        return products.stream()
                .filter(p -> !(p.getName().startsWith("S") 
                               && p.getPrice() < 5000 
                               && p.getQuantity() > 100))
                .sorted(Comparator.comparing(Product::getCategory).reversed()
                        .thenComparingDouble(Product::getPrice))
                .map(p -> new StringBuilder(p.getName()).reverse().toString())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Laptop", "Electronics", 20000, 25, 4.5));
        products.add(new Product(2, "Shoes", "Footwear", 4000, 120, 4.0));
        products.add(new Product(3, "Phone", "Electronics", 12000, 50, 4.8));
        products.add(new Product(4, "Shirt", "Clothing", 1500, 200, 3.9));
        products.add(new Product(5, "Smartwatch", "Electronics", 18000, 10, 4.2));
        products.add(new Product(6, "Bag", "Accessories", 2500, 80, 3.6));

        List<String> task7Result = task7(products);
        List<Integer> task8Result = task8(products);
        List<String> task9Result = task9(products);

        System.out.println("-------- TASK 7 RESULT --------");
        task7Result.forEach(System.out::println);

        System.out.println("\n-------- TASK 8 RESULT --------");
        task8Result.forEach(System.out::println);

        System.out.println("\n-------- TASK 9 RESULT --------");
        task9Result.forEach(System.out::println);
    }
}

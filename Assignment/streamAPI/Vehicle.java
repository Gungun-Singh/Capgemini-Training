import java.util.*;
import java.util.stream.*;

class Vehicle {
    private int id;
    private String brand;
    private String type;
    private double price;
    private int year;
    private double mileage;

    public Vehicle(int id, String brand, String type, double price, int year, double mileage) {
        this.id = id;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.year = year;
        this.mileage = mileage;
    }

    public int getId() { return id; }
    public String getBrand() { return brand; }
    public String getType() { return type; }
    public double getPrice() { return price; }
    public int getYear() { return year; }
    public double getMileage() { return mileage; }
}

public class VehicleTasks {

    // ----------------- TASK 13 -----------------
    public static List<String> task13(List<Vehicle> vehicles) {
        return vehicles.stream()
                .filter(v -> !(v.getType().equalsIgnoreCase("Sedan") 
                               && v.getPrice() > 800000 
                               && v.getMileage() < 18))
                .sorted(Comparator.comparingInt(Vehicle::getYear).reversed()
                        .thenComparingDouble(Vehicle::getPrice))
                .map(v -> v.getBrand().toUpperCase())
                .collect(Collectors.toList());
    }

    // ----------------- TASK 14 -----------------
    public static List<Integer> task14(List<Vehicle> vehicles) {
        return vehicles.stream()
                .filter(v -> !(v.getBrand().length() > 4 
                               && v.getPrice() >= 500000 
                               && v.getPrice() <= 1200000 
                               && v.getYear() > 2015))
                .sorted(Comparator.comparingDouble(Vehicle::getMileage)
                        .thenComparing(Vehicle::getBrand))
                .map(v -> v.getId() * 10)
                .collect(Collectors.toList());
    }

    // ----------------- TASK 15 -----------------
    public static List<String> task15(List<Vehicle> vehicles) {
        return vehicles.stream()
                .filter(v -> !(v.getType().startsWith("S") 
                               && v.getMileage() < 20 
                               && v.getPrice() > 600000))
                .sorted(Comparator.comparing(Vehicle::getBrand).reversed()
                        .thenComparingInt(Vehicle::getYear))
                .map(v -> new StringBuilder(v.getBrand()).reverse().toString())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(1, "Honda", "Sedan", 900000, 2020, 17));
        vehicles.add(new Vehicle(2, "Toyota", "SUV", 1200000, 2018, 22));
        vehicles.add(new Vehicle(3, "Ford", "Sedan", 750000, 2019, 19));
        vehicles.add(new Vehicle(4, "BMW", "Sedan", 850000, 2021, 16));
        vehicles.add(new Vehicle(5, "Audi", "SUV", 1100000, 2016, 20));
        vehicles.add(new Vehicle(6, "Skoda", "Sedan", 700000, 2017, 21));

        List<String> task13Result = task13(vehicles);
        List<Integer> task14Result = task14(vehicles);
        List<String> task15Result = task15(vehicles);

        System.out.println("-------- TASK 13 RESULT --------");
        task13Result.forEach(System.out::println);

        System.out.println("\n-------- TASK 14 RESULT --------");
        task14Result.forEach(System.out::println);

        System.out.println("\n-------- TASK 15 RESULT --------");
        task15Result.forEach(System.out::println);
    }
}

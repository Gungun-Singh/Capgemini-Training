package StreamAPItask;

import java.util.*;
import java.util.stream.*;

class Employee {

    private int id;
    private String name;
    private String department;
    private String jobTitle;
    private int age;
    private int yearsOfExperience;
    private double salary;
    private int performanceRating;

    public Employee(int id, String name, String department, String jobTitle,
                    int age, int yearsOfExperience, double salary,
                    int performanceRating) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.jobTitle = jobTitle;
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
        this.performanceRating = performanceRating;
    }

    public String getName() { return name; }
    public String getJobTitle() { return jobTitle; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public double getSalary() { return salary; }
    public int getPerformanceRating() { return performanceRating; }
}

public class task {
    public static void main(String[] args) {

        List<Employee> employees = List.of(
                new Employee(1, "Amit", "IT", "Manager", 35, 2, 120000, 4),
                new Employee(2, "Ravi", "HR", "Manager", 40, 10, 150000, 3),
                new Employee(3, "Neha", "IT", "Developer", 28, 5, 90000, 5),
                new Employee(4, "Sara", "IT", "Manager", 30, 1, 110000, 2)
        );

        List<String> result = employees.stream()
                // Filter managers with salary > 100k
                .filter(e -> e.getJobTitle().equalsIgnoreCase("Manager")
                        && e.getSalary() > 100000)

                // Sort by experience descending, then performance rating ascending
                .sorted(Comparator
                        .comparing(Employee::getYearsOfExperience).reversed()
                        .thenComparing(Employee::getPerformanceRating))

                // Map to reversed uppercase names
                .map(e -> new StringBuilder(e.getName())
                        .reverse()
                        .toString()
                        .toUpperCase())

                .collect(Collectors.toList());

        System.out.println(result);
    }
}

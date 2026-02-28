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

    public Employee(int id, String name, String department, String jobTitle, int age, int yearsOfExperience, double salary, int performanceRating) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.jobTitle = jobTitle;
        this.age = age;
        this.yearsOfExperience = yearsOfExperience;
        this.salary = salary;
        this.performanceRating = performanceRating;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDepartment() { return department; }
    public String getJobTitle() { return jobTitle; }
    public int getAge() { return age; }
    public int getYearsOfExperience() { return yearsOfExperience; }
    public double getSalary() { return salary; }
    public int getPerformanceRating() { return performanceRating; }
}

public class EmployeeTasks {

    // ----------------- TASK 1 -----------------
    public static List<String> task1(List<Employee> employees) {
        return employees.stream()
                .filter(e -> !(e.getJobTitle().equalsIgnoreCase("Developer") 
                               && e.getSalary() > 90000 
                               && e.getYearsOfExperience() < 4))
                .sorted(Comparator.comparingInt(Employee::getAge)
                        .thenComparing(Comparator.comparingInt(Employee::getPerformanceRating).reversed()))
                .map(e -> e.getName().toUpperCase() + "_DEV")
                .collect(Collectors.toList());
    }

    // ----------------- TASK 2 -----------------
    public static List<String> task2(List<Employee> employees) {
        return employees.stream()
                .filter(e -> !(e.getDepartment().equalsIgnoreCase("HR") 
                               && e.getPerformanceRating() < 6 
                               && e.getYearsOfExperience() > 6 
                               && e.getSalary() >= 50000 
                               && e.getSalary() <= 120000))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed()
                        .thenComparingInt(Employee::getYearsOfExperience))
                .map(e -> new StringBuilder(e.getName()).reverse().toString())
                .collect(Collectors.toList());
    }

    // ----------------- TASK 3 -----------------
    public static List<Integer> task3(List<Employee> employees) {
        return employees.stream()
                .filter(e -> !(e.getDepartment().length() > 5 
                               && e.getAge() >= 28 
                               && e.getAge() <= 45 
                               && e.getSalary() < 75000))
                .sorted(Comparator.comparingInt(Employee::getPerformanceRating).reversed()
                        .thenComparing(Employee::getName))
                .map(e -> e.getId() * 5)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1, "Alice", "IT", "Developer", 30, 3, 95000, 8));
        employees.add(new Employee(2, "Bob", "HR", "Manager", 40, 7, 60000, 5));
        employees.add(new Employee(3, "Charlie", "Finance", "Analyst", 35, 5, 70000, 9));
        employees.add(new Employee(4, "David", "IT", "Tester", 28, 2, 50000, 7));
        employees.add(new Employee(5, "Eve", "HR", "Recruiter", 32, 8, 55000, 6));

        // Running each task separately
        List<String> task1Result = task1(employees);
        List<String> task2Result = task2(employees);
        List<Integer> task3Result = task3(employees);

        System.out.println("-------- TASK 1 RESULT --------");
        task1Result.forEach(System.out::println);

        System.out.println("\n-------- TASK 2 RESULT --------");
        task2Result.forEach(System.out::println);

        System.out.println("\n-------- TASK 3 RESULT --------");
        task3Result.forEach(System.out::println);
    }
}

import java.util.*;
import java.util.stream.*;

class Student {
    private int id;
    private String name;
    private String course;
    private int age;
    private double marks;
    private int yearOfStudy;
    private String city;

    public Student(int id, String name, String course, int age, double marks, int yearOfStudy, String city) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.age = age;
        this.marks = marks;
        this.yearOfStudy = yearOfStudy;
        this.city = city;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getCourse() { return course; }
    public int getAge() { return age; }
    public double getMarks() { return marks; }
    public int getYearOfStudy() { return yearOfStudy; }
    public String getCity() { return city; }
}

public class StudentTasks {

    // ----------------- TASK 4 -----------------
    public static List<String> task4(List<Student> students) {
        return students.stream()
                .filter(s -> !(s.getCourse().equalsIgnoreCase("DataScience") 
                               && s.getMarks() > 75 
                               && s.getYearOfStudy() <= 2))
                .sorted(Comparator.comparingDouble(Student::getMarks).reversed()
                        .thenComparingInt(Student::getAge))
                .map(s -> s.getName().toLowerCase())
                .collect(Collectors.toList());
    }

    // ----------------- TASK 5 -----------------
    public static List<String> task5(List<Student> students) {
        return students.stream()
                .filter(s -> !(s.getCity().startsWith("M") 
                               && s.getMarks() >= 60 
                               && s.getMarks() <= 90 
                               && s.getAge() > 20))
                .sorted(Comparator.comparingInt(Student::getYearOfStudy)
                        .thenComparing(Comparator.comparingDouble(Student::getMarks).reversed()))
                .map(s -> String.valueOf(s.getId()))
                .collect(Collectors.toList());
    }

    // ----------------- TASK 6 -----------------
    public static List<String> task6(List<Student> students) {
        return students.stream()
                .filter(s -> !(s.getCourse().length() > 4 
                               && s.getMarks() < 65 
                               && s.getYearOfStudy() == 4))
                .sorted(Comparator.comparingInt(Student::getAge).reversed()
                        .thenComparing(Student::getCity))
                .map(s -> new StringBuilder(s.getName()).reverse().toString())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Alice", "DataScience", 19, 80, 1, "Mumbai"));
        students.add(new Student(2, "Bob", "ComputerScience", 21, 75, 2, "Delhi"));
        students.add(new Student(3, "Charlie", "Mechanical", 22, 65, 4, "Chennai"));
        students.add(new Student(4, "David", "DataScience", 23, 70, 3, "Bangalore"));
        students.add(new Student(5, "Eve", "Electrical", 20, 85, 3, "Mumbai"));
        students.add(new Student(6, "Frank", "Civil", 24, 60, 4, "Pune"));

        List<String> task4Result = task4(students);
        List<String> task5Result = task5(students);
        List<String> task6Result = task6(students);

        System.out.println("-------- TASK 4 RESULT --------");
        task4Result.forEach(System.out::println);

        System.out.println("\n-------- TASK 5 RESULT --------");
        task5Result.forEach(System.out::println);

        System.out.println("\n-------- TASK 6 RESULT --------");
        task6Result.forEach(System.out::println);
    }
}

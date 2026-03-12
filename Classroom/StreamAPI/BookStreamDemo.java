import java.util.*;
import java.util.stream.*;

class Book {
    int id;
    String title;
    String author;
    double price;

    Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public String toString() {
        return id + " " + title + " " + author + " " + price;
    }
}

public class BookStreamDemo {

    public static void main(String[] args) {

        List<Book> books = new ArrayList<>();

        books.add(new Book(1, "Java Basics", "James", 450));
        books.add(new Book(2, "Python Guide", "Guido", 600));
        books.add(new Book(3, "Spring Boot", "Rod", 800));
        books.add(new Book(4, "C Programming", "Dennis", 300));

        // Filter books price > 400
        List<Book> filtered = books.stream()
                .filter(b -> b.price > 400)
                .toList();

        System.out.println("Filtered Books:");
        filtered.forEach(System.out::println);

        //  Get only titles
        List<String> titles = books.stream()
                .map(b -> b.title)
                .toList();

        System.out.println("\nBook Titles:");
        System.out.println(titles);

        //  Sort by price ascending
        List<Book> sorted = books.stream()
                .sorted(Comparator.comparingDouble(b -> b.price))
                .toList();

        System.out.println("\nSorted by Price:");
        sorted.forEach(System.out::println);

        //  Find average price
        double avgPrice = books.stream()
                .collect(Collectors.averagingDouble(b -> b.price));

        System.out.println("\nAverage Price: " + avgPrice);

        //  Group by author
        Map<String, List<Book>> grouped = books.stream()
                .collect(Collectors.groupingBy(b -> b.author));

        System.out.println("\nGrouped by Author:");
        System.out.println(grouped);
    }
}

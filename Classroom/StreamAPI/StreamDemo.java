package SimpleInter;

import java.util.*;
import java.util.stream.*;

class Item {
    int id;
    String name;
    float price;

    Item(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class StreamDemo {
    public static void main(String[] args) {

        List<Item> items = new ArrayList<>();

        items.add(new Item(1, "Laptop", 50000));
        items.add(new Item(2, "Mobile", 20000));
        items.add(new Item(3, "Tablet", 15000));
        items.add(new Item(4, "Headphones", 2000));

        List<Item> filtered = items.stream()
                .filter(i -> i.price > 2500)
                .collect(Collectors.toList());

        System.out.println(filtered);

        var extractFields = items.stream()
                .map(i -> i.price)
                .toList();

        System.out.println(extractFields);

        Map<Boolean, List<Item>> partition = items.stream()
                .collect(Collectors.partitioningBy(i -> i.price > 1000));

        System.out.println(partition);

        System.out.println(items.stream()
                .collect(Collectors.summarizingInt(i -> (int) i.price)));
    }
}

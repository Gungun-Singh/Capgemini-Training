package Map_dependency_injection;

import java.util.Map;

public class Kit {

    private String name;
    private Map<String, Integer> items;

    public Kit(String name, Map<String, Integer> items) {
        this.name = name;
        this.items = items;
    }

    public String toString() {
        return "{ " + name + " " + items + " }";
    }
}
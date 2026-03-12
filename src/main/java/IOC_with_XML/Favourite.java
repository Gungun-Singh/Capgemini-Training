package IOC_with_XML;

public class Favourite {

    private String color;
    private String food;

    public Favourite() {
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String toString() {
        return "Favourite [color=" + color + ", food=" + food + "]";
    }
}
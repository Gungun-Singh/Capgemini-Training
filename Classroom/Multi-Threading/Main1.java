package multithreading;

public class Main1 {

    public static void main(String[] args) {

        NumberPrinter t1 = new NumberPrinter();
        NumberPrinter t2 = new NumberPrinter();

        t1.start();
        t2.start();
    }
}

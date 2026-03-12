public class Main {
    public static void main(String[] args) {

        try {
            int[] arr = new int[3];
            arr[5] = 10;
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Error");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Error");
        } catch (Exception e) {
            System.out.println("General Exception");
        }
    }
}

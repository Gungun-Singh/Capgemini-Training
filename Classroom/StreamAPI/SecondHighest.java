package StreamAPItask;

import java.util.*;

public class SecondHighest {

    public static int findSecondHighest(int[] arr) {
        return Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(-1);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 1, 9, 7};
        System.out.println(findSecondHighest(arr));
    }
}

import java.util.ArrayList;
import java.util.List;

public class GraycodeSeqGenerator {
    public static void main(String[] args) {
        generate(2);
    }

    private static void generate(int n) {
        List<Integer> result = new ArrayList<>();

        int totalNumbers = 1 << n; // Calculate 2 ^ n efficiently

        for (int i = 0; i < totalNumbers; i++) {
            int grayCodeNumber = i ^ (i >> 1);

            result.add(grayCodeNumber);
        }

        result.forEach(num -> System.out.print(num + " "));
    }
}

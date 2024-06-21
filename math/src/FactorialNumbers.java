import java.util.ArrayList;

public class FactorialNumbers {
    public static void main(String[] args) {
        System.out.println(solution(1L));
    }

    private static ArrayList<Long> solution(long N) {
        long product = 1L;
        ArrayList<Long> res = new ArrayList<>();

        for (long i = 1L; i <= N; i++) {
            product *= i;

            if (product > N) break;

            res.add(product);
        }


        return res;
    }
}

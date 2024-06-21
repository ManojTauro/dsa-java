public class SumOfSquareNumbers {
    public static void main(String[] args) {
        int c = 5;
        int left = 0;
        int right = c;
        boolean found = false;


        while (left < right) {
            int squareSum = (left * left) + (right * right);

            if (squareSum == c) {
                found = true;
                break;
            } else if (c < squareSum) right--;
            else left++;
        }

        System.out.println(found);
    }
}

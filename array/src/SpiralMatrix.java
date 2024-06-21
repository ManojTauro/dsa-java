import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{7}, {9}, {6}};

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        List<Integer> ans = new ArrayList<>();

        while (top <= bottom && left <= right) {
            for (int col = left; col <= right; col++)
                ans.add(matrix[top][col]);

            top++;

            for (int row = top; row <= bottom; row++)
                ans.add(matrix[row][right]);

            right--;

            if (top <= bottom) {
                for (int col = right; col >= left; col--)
                    ans.add(matrix[bottom][col]);

                bottom--;
            }

            if (left <= right) {
                for (int row = bottom; row >= top; row--)
                    ans.add(matrix[row][left]);

                left++;
            }
        }

        System.out.println(ans);
    }
}

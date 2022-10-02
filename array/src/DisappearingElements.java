import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.geeksforgeeks.org/queries-on-array-with-disappearing-and-reappearing-elements/#:~:text=Integer%20disappear%20in%20the%20order,two%20integers%20t%20and%20M.
public class DisappearingElements {
    private static final int[] input = {1,2,3,4,5};
    private static final int[][] queries = {{1,4}, {6,1}, {3,5}};

    public static void main(String[] args) {
        List<Integer> result = new ArrayList<>();
        runQueries(result);

        System.out.println(result);
    }

    private static void runQueries(List<Integer> result) {
        int size = input.length;

        for(int[] q: queries) {
            int time = q[0];
            int element = q[1];

            if(element > size) {
                result.add(-1);
                continue;
            }

            int turn = (time/size) % 2; //Determine even or odd turn
            int rem = time % size;

            //Array is empty
            if(rem == 0 && turn == 1) {
                result.add(-1);
                continue;
            }

            //Array is full
            if(rem == 0 && turn == 0) {
                if(element > size) result.add(-1);
                else result.add(input[element - 1]);
                continue;
            }

            //Odd turn
            if(turn == 1) {
                int curSize = rem;

                if(curSize < element) {
                    result.add(-1);
                    continue;
                }

                result.add(input[rem - 1]);
            } else {
                int curSize = size - rem;

                if(curSize < element) {
                    result.add(-1);
                    continue;
                }

                result.add(input[element - 1 + rem]);
            }
        }
    }
}

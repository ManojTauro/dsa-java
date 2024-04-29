import java.util.HashSet;
import java.util.Set;

// Not working when the string length is 3
public class SolarElectricBulbsSDE {
    public static void main(String[] args) {
        String[] input = {"001", "110011000001", "1000000", "00000", "1111110001", "1001", "1111"};

        for (String str : input)
            System.out.println(str + " = " + maxSolarBulbs1(str));
    }

    private static int maxSolarBulbs(String bulbs) {
        int prev = 0;
        int count = 0;
        Set<Integer> replacedBulbs = new HashSet<>();

        for (int cur = 0; cur < bulbs.length() - 1; cur++) {
            if (bulbs.charAt(cur) == '1') count++;

            if (bulbs.charAt(cur) == '0' &&
                    bulbs.charAt(prev) == '0' &&
                    bulbs.charAt(cur + 1) == '0' &&
                    !replacedBulbs.contains(prev)) {
                count++;
                replacedBulbs.add(cur);
            }
            prev = cur;
        }

        if (bulbs.charAt(bulbs.length() - 1) == '1') count++;

        if (bulbs.charAt(bulbs.length() - 1) == '0' &&
                bulbs.charAt(bulbs.length() - 2) == '0')
            count++;

        return count;
    }

    private static int maxSolarBulbs1(String str) {
        int start = 0;
        int count = 0;
        int totalZeroes = 0;

        while (start < str.length()) {
            int countZeroes = 0;
            if (str.charAt(start) == '1') {
                count++;
                start += 1;
                continue;
            } else {
                while (start < str.length() &&
                        str.charAt(start) == '0') {
                    countZeroes++;
                    start += 1;
                }
                totalZeroes += countZeroes;
                if (countZeroes > 2) count += countZeroes / 2;
            }
        }

        if (totalZeroes == str.length()) {
            if (totalZeroes % 2 == 0) return totalZeroes / 2;
            else return totalZeroes / 2 + 1;
        }

        return count;
    }
}

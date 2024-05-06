import java.util.Arrays;

public class Question_14 {
    public static void main(String[] args) {
        String[] strings = {
                "Rats live on no evil star",
                "A man, a plan, a canal, panama",
                "Lleve",
                "Tacotac",
                "asda"
        };

        for (String s : strings) {
            System.out.println(s + " -> " + isPermOfPalindrome(s));
        }
    }

    private static boolean isPermOfPalindrome(String s) {
        int[] frequency = buildFrequencyTable(s);
        System.out.println(Arrays.toString(frequency));
        return checkMaxOneOdd(frequency);
    }

    private static boolean checkMaxOneOdd(int[] table) {
        boolean foundOdd = false;

        for (int count : table) {
            if (count % 2 == 1) {
                if (foundOdd) return false;
                foundOdd = true;
            }
        }

        return true;
    }

    private static int[] buildFrequencyTable(String input) {
        int[] table = new int[26];

        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        for (char c : input.toCharArray()) {
            int val = Character.getNumericValue(c);

            if (a <= val && val <= z) table[val - a]++;
        }

        return table;
    }


}

package strings;

public class Pangrams {
    public static void main(String[] args) {
        var input = "We promptly judged antique ivory buckles for the next prize";
        System.out.println(pangrams(input));
    }

    public static String pangrams(String s) {
        int[] alphabets = new int[26];

        for (char c : s.toCharArray()) {
            if (!Character.isWhitespace(c)) {
                char lowerCase = Character.toLowerCase(c);
                alphabets[lowerCase - 'a'] = lowerCase;
            }

        }

        for (int a : alphabets) {
            if (a == 0) return "not pangram";
        }

        return "pangram";
    }
}

// Check Permutation
public class Question_12 {

    private static boolean permutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] count = new int[128];
        for (int i = 0; i < s1.length(); i++) count[s1.charAt(i)]++;

        for (int i = 0; i < s2.length(); i++) {
            int index = s2.charAt(i);
            count[index]--;

            if (count[index] < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "papel"}, {"carrot", "tarroc"}, {"hello", "llloh"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean anagram = permutation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + anagram);
        }
    }
}

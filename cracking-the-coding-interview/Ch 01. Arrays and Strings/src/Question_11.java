public class Question_11 {

    private static boolean isUniqueCharacters(String str) {
        if (str.length() > 128) return false;

        boolean[] chars = new boolean[128];

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i);
            if (chars[index]) return false;

            chars[index] = true;
        }

        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) System.out.println(word + ": " + isUniqueCharacters(word));
    }
}
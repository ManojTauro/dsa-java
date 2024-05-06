public class Question_16 {
    public static void main(String[] args) {
        String[] strs = {
                "",
                "aaaaabbbbaaaabbddc",
                "a",
                "abc"
        };

        for (String s : strs) {
            System.out.print(s + " -> ");
            System.out.println(compress(s));
        }
    }

    private static String compress(String s) {
        if (s.isEmpty()) return s;

        StringBuilder builder = new StringBuilder();
        int count = 0;
        char prev = s.charAt(0);

        for (char c : s.toCharArray()) {
            if (prev == c) count++;
            else {
                builder.append(prev).append(count);
                count = 1;
            }

            prev = c;
        }

        builder.append(prev).append(count);

        if (builder.toString().length() > s.length()) return s;
        return builder.toString();
    }
}

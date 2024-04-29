//https://www.reddit.com/r/leetcode/comments/196jfmj/amazon_oa/
public class ReverseBinaryString {
    public static void main(String[] args) {
        String[] input = {"00110101", "11010"};

        for (String s : input)
            System.out.println(minOperation(s));
    }

    // Using the longest prefix of rev in original string
    private static int minOperation(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int i = 0, j = 0;

        while (i < s.length() && j < rev.length()) {
            if (s.charAt(i) == rev.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return s.length() - j;
    }
}

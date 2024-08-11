package strings;

public class FunnyString {
    public static void main(String[] args) {
        String i1 = "acxz";
        String i2 = "bcxz";

        System.out.println(i1 + " " + funnyString(i1));
        System.out.println(i2 + " " + funnyString(i2));
    }

    public static String funnyString(String s) {
        StringBuilder builder = new StringBuilder(s);
        String reverse = builder.reverse().toString();

        int len = s.length();

        int[] ordOrg = new int[len];
        int[] ordRev = new int[len];

        for (int i = 0; i < len - 1; i++) {
            int cur = s.charAt(i);
            int next = s.charAt(i + 1);

            int curR = reverse.charAt(i);
            int nextR = reverse.charAt(i + 1);

            ordOrg[i] = Math.abs(cur - next);
            ordRev[i] = Math.abs(curR - nextR);
        }

        for (int i = 0; i < ordOrg.length; i++) {
            if (ordOrg[i] != ordRev[i]) return "Not Funny";
        }

        return "Funny";
    }
}

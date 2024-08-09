import java.util.Stack;

public class SuperReducedString {
    public static void main(String[] args) {
        System.out.println(superReducedString("aaabccddd"));
    }

    public static String superReducedString(String s) {
        Stack<Character> st = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!st.isEmpty() && st.peek() == c) st.pop();
            else st.push(c);
        }

        StringBuilder builder = new StringBuilder();
        if (st.isEmpty()) return "";
        else builder.append(st.pop());

        return builder.toString();

    }
}

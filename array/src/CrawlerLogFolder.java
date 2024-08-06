import java.util.Stack;

public class CrawlerLogFolder {
    public static void main(String[] args) {
        String[] logs = {"d1/", "../", "../", "../"};

        Stack<String> st = new Stack<>();

        for (String s : logs) {
            if (s.charAt(0) == '.') {
                if (!st.isEmpty() && s.charAt(1) != '/')
                    st.pop();
            } else st.push(s);
        }

        System.out.println(st.size());
    }
}

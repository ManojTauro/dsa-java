import java.util.Stack;

public class ValidParentheses {
    private static final String input = "[{";
    public static void main(String[] args) {
        System.out.println(isValid(input));
    }

    private static String isValid(String s) {
        // if(s == null || s.isEmpty()) return "NO";

        char[] brackets = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for(int i=0; i<brackets.length; i++) {
            char c = brackets[i];

            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }

            if(c == ')' && (stack.isEmpty() || stack.pop() != '(')) return "NO";
            else if(c == '}' && (stack.isEmpty() || stack.pop() != '{')) return "NO";
            else if(c == ']' && (stack.isEmpty() || stack.pop() != '[')) return "NO";

//             switch(c) {
//                 case ')': if(stack.isEmpty() || stack.pop() != '(') return "NO"; System.out.println("NO"); break;
//                 case '}': if(stack.isEmpty() || stack.pop() != '{') return "NO"; System.out.println("NO"); break;
//                 case ']': if(stack.isEmpty() || stack.pop() != '[') return "NO"; System.out.println("NO"); break;
//                 default: stack.push(c);
//             }
        }

//        System.out.println("YES");
        if(stack.isEmpty()) return "YES";
        else return "NO";
    }
}

import java.util.Arrays;
import java.util.List;

public class Codec {
    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder output = new StringBuilder();

        for (String str : strs) {
            char[] temp = str.toCharArray();
            for (int i = 0; i < temp.length; i++) {
                if (!Character.isUpperCase(temp[i])) {
                    output.append((int) temp[i]);
                    System.out.println((int) temp[i]);
                } else {
                    output.append((int) temp[i]);
                    System.out.println((int) temp[i]);
                }
            }
            output.append("/");
        }

        return output.toString();
    }

    // Decodes a single string to a list of strings.
//    public List<String> decode(String s) {
//
//    }

    public static void main(String[] args) {
        List<String> input = Arrays.asList("Hello", "World");

        System.out.println(encode(input));
    }
}

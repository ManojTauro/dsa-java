import java.util.Arrays;

// URlify
public class Question_13 {

    private static void replaceSpaces(char[] str, int trueLength) {
        int spaceCount = 0;

        for (int i = 0; i < trueLength; i++) if (str[i] == ' ') spaceCount++;

        int lastIndex = trueLength + (spaceCount * 2);

        for (int i = trueLength - 1; i >= 0; i--) {
            if (str[i] == ' ') {
                str[--lastIndex] = '0';
                str[--lastIndex] = '2';
                str[--lastIndex] = '%';
//                i = i - 2;
            } else str[--lastIndex] = str[i];
        }
    }

    public static int findLastCharacter(char[] str) {
        for (int i = str.length - 1; i >= 0; i--) {
            if (str[i] != ' ') {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        char[] arr = str.toCharArray();
        int trueLength = findLastCharacter(arr) + 1;
        replaceSpaces(arr, trueLength);
        System.out.println("\"" + Arrays.toString(arr) + "\"");
    }
}

import java.util.ArrayList;
import java.util.List;

public class FirstUniqueCharacter {
    private static final String s = "aadadaad";

    public static void main(String[] args) {
        int[] frequency = new int[26];

        for(int i=0; i<s.length(); i++) {
            char curChar = s.charAt(i);
            frequency[curChar - 'a']++;
        }

        for(int i=0; i<s.length(); i++) {
            if(frequency[i] == 1) System.out.println(i);
        }

        System.out.println(-1);

//        if(list.size() == 0) return -1;
//        else return s.indexOf(list.get(0));
    }
}

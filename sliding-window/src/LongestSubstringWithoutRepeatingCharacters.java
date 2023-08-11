import java.util.HashSet;
import java.util.Set;

//https://www.youtube.com/watch?v=wiGpQwVHdE0
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";

        System.out.println(lengthOfLongestSubstring(s));
    }

    public static String lengthOfLongestSubstring(String s) {
        String output = "";

        if(s == null || s.length() == 0) System.out.println(s);;

        Set<Character> subStr = new HashSet<>();
        int windowStart = 0;
        int maxSubStrLen = 0;

        for(int windowEnd=0; windowEnd<s.length(); windowEnd++) {
            char endCh = s.charAt(windowEnd);

            while(subStr.contains(endCh))
                subStr.remove(s.charAt(windowStart++));

            subStr.add(endCh);

            if (output.length() < windowEnd - windowStart + 1) {
                output = s.substring(windowStart, windowEnd + 1);
            }

            maxSubStrLen = Math.max(maxSubStrLen, windowEnd - windowStart + 1);
        }


        System.out.println("maxSubStrLen: "+maxSubStrLen);
        return output;
    }
}

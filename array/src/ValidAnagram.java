import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("rat", "car"));
    }
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for(int j=0; j<t.length(); j++) {
            char c = t.charAt(j);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            } else {
                return false;
            }
        }

        // Map.Entry<Character, Integer> entry = map.entrySet();

        for(Map.Entry<Character, Integer> e: map.entrySet()) {
            if(e.getValue() != 0) return false;
        }

        return true;
    }
}

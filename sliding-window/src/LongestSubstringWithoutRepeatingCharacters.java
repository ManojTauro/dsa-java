//https://www.youtube.com/watch?v=wiGpQwVHdE0
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
        int result = 0;
        int[] cache = new int[256];

        for (int right = 0, left = 0; right < s.length(); right++) {
            left = (cache[s.charAt(right)] > 0) ? Math.max(left, cache[s.charAt(right)]) : left;
            cache[s.charAt(right)] = right + 1;
            result = Math.max(result, right - left + 1);
        }

        System.out.println(result);
    }
}

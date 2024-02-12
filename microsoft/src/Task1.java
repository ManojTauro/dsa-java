// For a problem statement please refer
// C:\Users\Manu\Desktop\Manoj\Studies\Interview\full time\microsoft

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    private static final String S1 = "NAABXXAN";
    private static final String S2 = "NAANAAXNABABYNNBZ";
    private static final String S3 = "QABAAAWOBL";

    public static void main(String[] args) {
        System.out.println(solution(S1));
        System.out.println(solution(S2));
        System.out.println(solution(S3));
    }

    private static int solution(String s) {
        int[] letterCount = new int[26];
        int maxMoves = Integer.MAX_VALUE;
        Map<Character, Integer> requiredLetters = new HashMap<>();
        requiredLetters.put('B', 1);
        requiredLetters.put('A', 3);
        requiredLetters.put('N', 2);

        for (int i = 0; i < s.length(); i++)
            letterCount[s.charAt(i) - 'A']++;

        for (Map.Entry<Character, Integer> entry : requiredLetters.entrySet()) {
            int count = letterCount[entry.getKey() - 'A'];
            if (count != 0)
                maxMoves = Math.min(maxMoves, count / entry.getValue());
            else return 0;
        }

        return maxMoves;
    }
}
import java.util.*;

public class AlienDict {
    public static void main(String[] args) {
        String[] input = {"z", "o"};

        String[] input1 = {"abc", "bcd", "cde"};
        String[] input2 = {"aa", "aab", "ab", "b", "babbb"};
        System.out.println(findOrder(input2));
    }

    static List<List<Integer>> adj = new ArrayList<>();
    static Set<Character> set = new HashSet<>();

    public static String findOrder(String[] words) {
        int[] exist = new int[26];
        int indegree[] = new int[26];

        for (String word : words) {
            for (char ch : word.toCharArray()) {
                exist[ch - 'a'] = 1;
                indegree[ch - 'a'] = 0;
            }
        }

        getAdj(words);

        for (int i = 0; i < 26; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (exist[i] == 1 && indegree[i] == 0) q.offer(i);
        }

        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int adjNode : adj.get(node)) {
                indegree[adjNode]--;
                if (indegree[adjNode] == 0) q.offer(adjNode);
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int it : topo) {
            char c = (char) (it + (int) ('a'));
            // if (set.contains(c))
            ans.append(c);
        }

        // System.out.println(ans.toString());
        return ans.toString();
    }

    private static void getAdj(String[] words) {
        for (int i = 0; i < 26; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];

            int len = Math.min(word1.length(), word2.length());

            for (int j = 0; j < len; j++) {
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);


                if (c1 != c2) {
                    adj.get(c1 - 'a').add(c2 - 'a');
                    break;
                }
            }
        }
    }
}

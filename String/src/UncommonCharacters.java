public class UncommonCharacters {
    public static void main(String[] args) {
        String A = "geeksforgeeks";
        String B = "geeksquiz";

        StringBuilder result = new StringBuilder();

        int[] hash = new int[26];

        for(int i=0; i<A.length(); i++)
            hash[A.charAt(i) - 'a'] = 1;

        for(int i=0; i<B.length(); i++) {
            int index = B.charAt(i) - 'a';

            if(hash[index] == 1 || hash[index] == -1)
                hash[index] = -1;
            else
                hash[index] = 2;
        }

        for(int i=0; i<hash.length; i++)
            if(hash[i] == 1 || hash[i] == 2) result.append(String.valueOf((char) (i + 'a')));

        System.out.println( result.toString());
    }
}

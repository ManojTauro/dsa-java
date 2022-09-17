public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if(s == null) return false;

        String alpn = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        System.out.println(alpn);

        if(alpn.length() < 1) return true;

        char[] charArray = alpn.toCharArray();

        int charLength = charArray.length;

        for(int i=0, j=charLength-1; i<charLength; i++, j--) {
            if(charArray[i] != charArray[j]) return false;
        }

        return true;
    }
}
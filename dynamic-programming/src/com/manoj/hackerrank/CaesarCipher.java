package com.manoj.hackerrank;

public class CaesarCipher {
    public static void main(String[] args) {
        String input = "zzz";
        int k = 27;

//        System.out.println(('z' + k) % 26);
        System.out.println(caesarCipher(input, k));
    }

    public static String caesarCipher(String s, int k) {
        StringBuilder builder = new StringBuilder();
        k = k % 26;

        for (char c : s.toCharArray()) {

            if (Character.isAlphabetic(c)) {
                if (Character.isLowerCase(c)) {
                    if (c + k > 'z') {
                        builder.append(Character.toString((c + k - 26)));
                    } else {
                        builder.append(Character.toString(c + k));
                    }
                } else {
                    if (c + k > 'Z') {
                        builder.append(Character.toString((c + k - 26)));
                    } else {
                        builder.append(Character.toString(c + k));
                    }
                }
            } else {
                builder.append(Character.toString(c));
            }

        }

        return builder.toString();
    }
}

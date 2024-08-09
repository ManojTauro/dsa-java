package com.manoj.hackerrank;

import java.util.stream.IntStream;

public class MarsExploration {
    public static void main(String[] args) {
        String input = "SOSSPSSQSSOR";
        System.out.println(marsExploration(input));
    }

    public static int marsExploration(String s) {

//        for (int i = 0; i < s.length(); i = i + 3) {
//            for (int j = i; j < i + 3; j++) {
//                char cur = s.charAt(j);
//                if (i % 2 == 0) {
//                    if (j % 2 == 0 && cur != 'S') count++;
//                    if (j % 2 != 0 && cur != 'O') count++;
//                } else {
//                    if (j % 2 != 0 && cur != 'S') count++;
//                    if (j % 2 == 0 && cur != 'O') count++;
//                }
//            }
//        }

        String org = "SOS";


        return (int) IntStream.range(0, s.length())
                .filter(i -> s.charAt(i) != org.charAt(i % 3))
                .count();

    }
}

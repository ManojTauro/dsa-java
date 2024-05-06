public class Question_15 {
    public static void main(String[] args) {
        String[][] tests = {
                {"a", "b", "true"},
                {"", "d", "true"},
                {"d", "de", "true"},
                {"pale", "pse", "false"},
                {"acdsfdsfadsf", "acdsgdsfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdfadsf", "true"},
                {"acdsfdsfadsf", "acdsfdsfads", "true"},
                {"acdsfdsfadsf", "cdsfdsfadsf", "true"},
                {"adfdsfadsf", "acdfdsfdsf", "false"},
                {"adfdsfadsf", "bdfdsfadsg", "false"},
                {"adfdsfadsf", "affdsfads", "false"},
                {"pale", "pkle", "true"},
                {"pkle", "pable", "false"}
        };

        for (int i = 0; i < tests.length; i++) {
            String[] test = tests[i];
            String a = test[0];
            String b = test[1];
            boolean expected = test[2].equals("true");

            test(a, b, expected);
            test(b, a, expected);
        }
    }

    public static void test(String a, String b, boolean expected) {
        boolean resultA = oneEditAway(a, b);

        if (resultA == expected) {
            System.out.println(a + ", " + b + ": success");
        } else {
            System.out.println(a + ", " + b + ": error");
        }
    }

    private static boolean oneEditAway(String s1, String s2) {
        if (s1.isEmpty() && s2.length() == 1) return true;

        int[] frequencyS1 = buildFrequencyTable(s1);
        int[] frequencyS2 = buildFrequencyTable(s1);

        int a = Character.getNumericValue('a');

        for (char c : s2.toCharArray()) {
            int val = Character.getNumericValue(c) - a;
            if (frequencyS1[val] != 0) frequencyS1[val]--;
            if (frequencyS2[val] != 0) frequencyS2[val]--;
        }

        int countS1 = 0;
        for (int i : frequencyS1) countS1 += i;

        int countS2 = 0;
        for (int i : frequencyS1) countS2 += i;

        return countS1 == countS2;
    }

    private static int[] buildFrequencyTable(String input) {
        int[] table = new int[26];

        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');

        for (char c : input.toCharArray()) {
            int val = Character.getNumericValue(c);

            if (a <= val && val <= z) table[val - a]++;
        }

        return table;
    }
}

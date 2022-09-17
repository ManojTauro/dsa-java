public class FrequentDigit {
    public static void main(String[] args) {
        System.out.println(getFrequentDigit(1000));
    }

    private static int getFrequentDigit(int num) {
        int maxFrequentDigitCount = 0;
        int maxFrequentDigit = 0;

        for(int i=0; i<=9; i++) {
            int noOfOccurrence = countOccurrence(num, i);
            maxFrequentDigitCount = Math.max(maxFrequentDigitCount, noOfOccurrence);
            if(noOfOccurrence >= maxFrequentDigitCount) maxFrequentDigit = i;
        }

//        System.out.println(lastDigit);

        return maxFrequentDigit;
    }

    private static int countOccurrence(int num, int digit) {
        int count = 0;

        while (num > 0) {
            int lastDigit = num%10;
            if(lastDigit == digit) count++;
            num = num/10;
        }

        return count;
    }
}

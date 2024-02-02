package main.java.com.leetcode._2272;

public class SubstringWithLargestVariance {

    public int largestVariance(String s) {
        int[] counter = new int[26];
        for (char c : s.toCharArray()) {
            counter[c-'a']++;
        }
        int globalMax = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if(i == j || counter[i]==0||counter[j] == 0){
                    continue;
                }

                char major = (char) ('a' + i);
                char minor = (char)('a'+j);
                int majorCount = 0;
                int minorCount = 0;
                int restMinor = counter[j];
                for (char c : s.toCharArray()) {
                    if(c == major){
                        majorCount++;
                    }
                    if(c == minor){
                        minorCount++;
                        restMinor--;
                    }
                    if(minorCount > 0){
                        globalMax = Math.max(globalMax, majorCount - minorCount);
                    }

                    if(majorCount < minorCount && restMinor > 0){
                        majorCount = 0;
                        minorCount = 0;
                    }
                }

            }
        }
        return globalMax;
    }


    public static void main(String[] args) {
        var s = new SubstringWithLargestVariance();
        System.out.println(s.largestVariance("aababbb"));//Output: 3
        System.out.println(s.largestVariance("abcde"));//Output: 0
    }
}

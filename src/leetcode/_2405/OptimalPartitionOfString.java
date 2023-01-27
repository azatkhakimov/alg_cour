package leetcode._2405;

import java.util.Arrays;

public class OptimalPartitionOfString {
    public int partitionString(String s) {
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        int count = 1;
        int substringStart = 0;
        for (int i = 0; i < s.length(); i++) {
            if(lastSeen[s.charAt(i)-'a'] >= substringStart){
                count++;
                substringStart = i;
            }
            lastSeen[s.charAt(i)-'a'] = i;
        }
        return count;
    }

    public static void main(String[] args) {
        OptimalPartitionOfString o = new OptimalPartitionOfString();
        System.out.println(o.partitionString("abacaba"));//Output: 4
        System.out.println(o.partitionString("ssssss"));//Output: 6
    }
}

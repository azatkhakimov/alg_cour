package main.java.com.leetcode._458;

public class PoorPigs {
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int pigs = 0;
        while (Math.pow(minutesToTest/minutesToDie+1, pigs) < buckets){
            pigs += 1;
        }
        return pigs;
    }

    public static void main(String[] args) {
        PoorPigs poorPigs = new PoorPigs();
        System.out.println(poorPigs.poorPigs(1000,  15,  60));//Output: 5
        System.out.println(poorPigs.poorPigs(4,  15,  15));//Output: 2
        System.out.println(poorPigs.poorPigs(4,  15,  30));//Output: 2
    }
}

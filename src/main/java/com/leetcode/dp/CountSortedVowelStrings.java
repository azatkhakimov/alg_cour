package main.java.com.leetcode.dp;

public class CountSortedVowelStrings {
    public int countVowelStrings(int n) {
        int a = 1;
        int e = 1;
        int i = 1;
        int o = 1;
        int u = 1;
        while (n > 1){
            a = (a+e+i+o+u);
            e = (e+i+o+u);
            i = (i+o+u);
            o= (o+u);
            u = (u);
            n--;
        }
        return a+e+i+o+u;
    }

    public static void main(String[] args) {
        CountSortedVowelStrings countSortedVowelStrings = new CountSortedVowelStrings();
        System.out.println(countSortedVowelStrings.countVowelStrings(2));
    }

}

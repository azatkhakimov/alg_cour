package leetcode._1657;

import java.util.Arrays;

public class DetermineIfTwoStringsAreClose {

    public boolean closeStrings(String word1, String word2) {
        int N = 26;
        int[] word1arr = new int[N];
        int[] word2arr = new int[N];

        for (char c : word1.toCharArray()) {
            word1arr[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {
            word2arr[c-'a']++;
        }
        for (int i = 0; i < N; i++) {
            if(word1arr[i] == word2arr[i]){
                continue;
            }
            if(word1arr[i] == 0 || word2arr[i] ==0 ){
                return false;
            }
        }
        Arrays.sort(word1arr);
        Arrays.sort(word2arr);

        for (int i = 0; i < N; i++) {
            if(word1arr[i] != word2arr[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        DetermineIfTwoStringsAreClose close = new DetermineIfTwoStringsAreClose();
        System.out.println(close.closeStrings("abc", "bca"));//Output: true
        System.out.println(close.closeStrings("a", "aa"));//Output: false
        System.out.println(close.closeStrings("cabbba", "abbccc"));//Output: true
    }
}

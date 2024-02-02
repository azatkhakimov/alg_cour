package main.java.com.leetcode.array._318;

public class MaximumProductWordLengths {
    public int maxProduct(String[] words) {
        if(words == null || words.length == 0){
            return 0;
        }
        int len = words.length;
        int[] value = new int[len];
        for (int i = 0; i < len; i++) {
            String temp  = words[i];
            value[i] = 0;
            for (char c : temp.toCharArray()) {
                value[i] |= 1 << c - 'a';
            }
        }
        int maxProduct = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if(((value[i] & value[j]) == 0 && (words[i].length()*words[j].length() > maxProduct))){
                    maxProduct = words[i].length()*words[j].length();
                }
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        MaximumProductWordLengths maximumProductWordLengths = new MaximumProductWordLengths();
        System.out.println(maximumProductWordLengths.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));//16
    }
}

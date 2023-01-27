package leetcode._1768;

public class MergeStringsAlternately {

    public String mergeAlternately(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while (i < length1 || j < length2){
            if(i < length1){
                sb.append(word1.charAt(i++));
            }
            if(j < length2){
                sb.append(word2.charAt(j++));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MergeStringsAlternately m =  new MergeStringsAlternately();
        System.out.println(m.mergeAlternately( "abc",  "pqr"));//Output: "apbqcr"
        System.out.println(m.mergeAlternately( "ab",  "pqrs"));//Output: "apbqrs"
    }
}

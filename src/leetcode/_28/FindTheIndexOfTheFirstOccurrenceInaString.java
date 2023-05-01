package leetcode._28;

public class FindTheIndexOfTheFirstOccurrenceInaString {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if(n < m){
            return -1;
        }
        int[] longestBorder = new int[m];
        int prev = 0;
        int i = 1;
        while (i < m){
            if(needle.charAt(i) == needle.charAt(prev)){
                prev +=1;
                longestBorder[i] = prev;
                i+=1;
            }else {
                if(prev == 0){
                    longestBorder[i] = 0;
                    i += 1;
                }else {
                    prev = longestBorder[prev-1];
                }
            }
        }
        int haystackPointer = 0;
        int needlePointer  = 0;
        while (haystackPointer < n){
            if(haystack.charAt(haystackPointer) == needle.charAt(needlePointer)){
                needlePointer += 1;
                haystackPointer +=1;
                if(needlePointer == m){
                    return haystackPointer-m;
                }
            }else {
                if(needlePointer == 0){
                    haystackPointer+=1;
                }else {
                    needlePointer = longestBorder[needlePointer-1];
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInaString f = new FindTheIndexOfTheFirstOccurrenceInaString();
        System.out.println(f.strStr("sadbutsad", "sad"));//Output: 0
        System.out.println(f.strStr("leetcode", "leeto"));//Output: -1
    }
}

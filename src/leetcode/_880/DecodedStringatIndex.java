package leetcode._880;

public class DecodedStringatIndex {


    public String decodeAtIndex(String s, int k) {
        int i;
        long n = 0;
        for (i = 0; n < k; i++) {
            n = Character.isDigit(s.charAt(i)) ? n * (s.charAt(i)-'0') : n+1;
        }
        for (i--; i > 0; i--) {
            if(Character.isDigit(s.charAt(i))){
                n /= s.charAt(i)-'0';
                k %= n;
            }else {
                if(k % n == 0){
                    break;
                }
                n--;
            }
        }
        return Character.toString(s.charAt(i));
    }

    public static void main(String[] args) {
        var d = new DecodedStringatIndex();
        System.out.println(d.decodeAtIndex("leet2code3", 10));//Output: "o"
        System.out.println(d.decodeAtIndex("ha22",  5));//Output: "h"
        System.out.println(d.decodeAtIndex("a2345678999999999999999", 1));//Output: "a"
    }
}

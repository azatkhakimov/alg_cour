package main.java.com.leetcode._1323;

public class Maximum69Number {
    public int maximum69Number (int num) {
        char[] numChars = Integer.toString(num).toCharArray();
        for (int i = 0; i < numChars.length; i++) {
            if(numChars[i] == '6'){
                numChars[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(numChars));
    }
    public static void main(String[] args) {
        Maximum69Number maximum69Number = new Maximum69Number();
        System.out.println(maximum69Number.maximum69Number(9669));//Output: 9969
        System.out.println(maximum69Number.maximum69Number(9996));//Output: 9999
        System.out.println(maximum69Number.maximum69Number(9999));//Output: 9999
    }
}

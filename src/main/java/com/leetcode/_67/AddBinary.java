package main.java.com.leetcode._67;

public class AddBinary {
    public String addBinary(String a, String b) {
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();

        while (i >= 0 || j >= 0){
            int sum = carry;
            if(i >= 0){
                sum += a.charAt(i--)-'0';
            }
            if(j >= 0){
                sum += b.charAt(j--)-'0';
            }
            sb.insert(0, sum % 2);
            carry = sum/2;
        }
        if(carry > 0){
            sb.insert(0, 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        AddBinary b = new AddBinary();
        System.out.println(b.addBinary("11",  "1"));//Output: "100"
        System.out.println(b.addBinary("1010",  "1011"));//Output: "10101"
    }
}

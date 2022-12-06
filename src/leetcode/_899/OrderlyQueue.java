package leetcode._899;

import java.util.Arrays;

public class OrderlyQueue {
    public String orderlyQueue(String s, int k) {
        if(k > 1){
            char[] chrs = s.toCharArray();
            Arrays.sort(chrs);
            return String.valueOf(chrs);
        }else {
            String min = s;
            for (int i = 0; i < s.length(); i++) {
                s = s.substring(1)+s.charAt(0);
                min = min.compareTo(s) < 0 ? min : s;
            }
            return min;
        }
    }

    public static void main(String[] args) {
        OrderlyQueue orderlyQueue = new OrderlyQueue();
        System.out.println(orderlyQueue.orderlyQueue("cba", 1));//Output: "acb"
        System.out.println(orderlyQueue.orderlyQueue("baaca", 3));//Output: "aaabc"
    }
}

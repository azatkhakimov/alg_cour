package leetcode._1291;

import java.util.ArrayList;
import java.util.List;

public class SequentialDigits {


    public List<Integer> sequentialDigits(int low, int high) {
        String sample = "123456789";
        int n = 10;
        List<Integer> nums = new ArrayList<>();
        int lowLen  = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        for (int length = lowLen; length < highLen+1; length++) {
            for (int start = 0; start < n - length; start++) {
                int num = Integer.parseInt(sample.substring(start, start+length));
                if(num >= low && num <= high){
                    nums.add(num);
                }
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        var s = new SequentialDigits();
        System.out.println(s.sequentialDigits(100 ,300));//Output: [123,234]
        System.out.println(s.sequentialDigits(1000, 13000));//Output: [1234,2345,3456,4567,5678,6789,12345]
    }
}

package leetcode._1802;

public class MaximumValueataGivenIndexinaBoundedArray {

    public int maxValue(int n, int index, int maxSum) {
        int left = 0;
        int right = maxSum;
        while (left < right){
            int mid = (left+right+1)/2;
            if(getSum(index, mid, n) <= maxSum){
                left = mid;
            }else {
                right = mid - 1;
            }
        }
        return left;
    }

    private long getSum(int index, int value, int n) {
        long count = 0;
        if (value > index) {
            count += (long)(value+value-index)*(index+1)/2;
        }else {
            count += (long)(value+1)*value/2 + index - value +1;
        }
        if(value >= n- index){
            count += (long)(value+value-n+1+index)*(n-index)/2;
        }else {
            count += (long)(value+1)*value/2+n-index-value;
        }

        return count-value;
    }


    public static void main(String[] args) {
        var m = new MaximumValueataGivenIndexinaBoundedArray();
        System.out.println(m.maxValue(4,2,6));//Output: 2
        System.out.println(m.maxValue(6,1,10));//Output: 3
    }
}

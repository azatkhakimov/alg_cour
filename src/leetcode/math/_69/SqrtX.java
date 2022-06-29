package leetcode.math._69;

public class SqrtX {
    public int mySqrt(int x) {
        if(x == 0){
            return x;
        }
        int left = 1;
        int right = x;
        while (true){
            int mid = left + (right-left)/2;

            if(mid > x/mid){
                right = mid-1;
            }else {
                if(mid + 1 > x/(mid+1)){
                    return mid;
                }
                left = mid+1;
            }
        }
    }
    public static void main(String[] args) {
        SqrtX sqrtX = new SqrtX();
        System.out.println(sqrtX.mySqrt(8));
    }
}

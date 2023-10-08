package leetcode._343;

public class IntegerBreak {

    public int integerBreak(int n) {
        if( n <= 3){
            return n-1;
        }

        int ans = 1;
        while (n > 4){
            ans *= 3;
            n -= 3;
        }
        return ans * n;
    }


    public static void main(String[] args) {
        var i = new IntegerBreak();
        System.out.println(i.integerBreak(2));//Output: 1 Explanation: 2 = 1 + 1, 1 × 1 = 1.
        System.out.println(i.integerBreak(10));//Output: 36 Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
    }
}

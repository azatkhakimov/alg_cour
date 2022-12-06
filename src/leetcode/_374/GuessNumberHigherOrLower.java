package leetcode._374;

public class GuessNumberHigherOrLower {
    public int guessNumber(int n) {
        if(n == 1){
            return n;
        }
        int lo = 1;
        int hi = n;
        while(lo <= hi){
            int mid = lo+(hi-lo)/2;
            int guess = guess(mid);
            if(guess == 0){
                return mid;
            }else if(guess == -1){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }
        return -1;
    }

    private int guess(int mid) {
        //realization at leetcode
        return 0;
    }

    public static void main(String[] args) {

    }
}

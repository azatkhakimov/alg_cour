package main.java.com.leetcode.array._1423;

public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int cardPoint : cardPoints) {
            sum += cardPoint;
        }

        int answer = 0;
        int window = 0;
        int n = cardPoints.length;

        if(n == k){
            return sum;
        }

        for(int i = 0; i < n-k-1; i++){
            window += cardPoints[i];
        }

        for (int i = n-k-1; i < n; i++){
            window += cardPoints[i];
            answer = Math.max(answer, sum - window);
            window -= cardPoints[i-(n-k-1)];
        }
        return answer;
    }
    public static void main(String[] args) {
        MaximumPointsYouCanObtainFromCards test = new MaximumPointsYouCanObtainFromCards();
        System.out.println(test.maxScore(new int[]{1,2,3,4,5,6,1}, 3));//Output: 12;
    }
}

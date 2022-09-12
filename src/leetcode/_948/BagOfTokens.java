package leetcode._948;

import java.util.Arrays;

//https://www.youtube.com/watch?v=1GubKefOabc
public class BagOfTokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int maxPoints = 0;
        int points = 0;
        int i = 0;
        int j = tokens.length-1;
        while (i <= j){
            if(power >= tokens[i]){
                points++;
                power -= tokens[i++];
                maxPoints = Math.max(maxPoints, points);
            }else if(points > 0){
                points--;
                power += tokens[j--];
            }else {
                return maxPoints;
            }
        }
        return maxPoints;
    }

    public static void main(String[] args) {
        BagOfTokens bagOfTokens = new BagOfTokens();
        System.out.println(bagOfTokens.bagOfTokensScore(new int[]{100}, 50));//Output: 0
        System.out.println(bagOfTokens.bagOfTokensScore(new int[]{100,20}, 150));//Output: 1
        System.out.println(bagOfTokens.bagOfTokensScore(new int[]{100,200,300,400}, 200));//Output: 2
    }

}

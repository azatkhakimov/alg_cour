package leetcode._2024;

import java.util.HashMap;

//    Time complexity: O(n)O(n)O(n)
//            In the iteration of the right boundary right, we shift it from 0 to n - 1. Although we may move the left boundary left in each step, left always stays to the left of right, which means left moves at most n - 1 times.
//            At each step, we update the value of an element in the hash map count, which takes constant time.
//            To sum up, the overall time complexity is O(n)O(n)O(n).
//
//            Space complexity: O(1)O(1)O(1)
//            We only need to update two indices left and right. During the iteration, we need to count the number of T and F, which also takes O(1)O(1)O(1) space.

public class MaximizetheConfusionofanExam {


    public int maxConsecutiveAnswers(String answerKey, int k) {

        int maxSize = k;
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < k; i++) {
            count.put(answerKey.charAt(i), count.getOrDefault(answerKey.charAt(i), 0)+1);
        }

        int left = 0;
        for(int right = k; right < answerKey.length(); right++){
            count.put(answerKey.charAt(right), count.getOrDefault(answerKey.charAt(right), 0)+1);
            while (Math.min(count.getOrDefault('T', 0), count.getOrDefault('F', 0)) > k){
                count.put(answerKey.charAt(left), count.get(answerKey.charAt(left))-1);
                left++;
            }
            maxSize = Math.max(maxSize, right-left+1);
        }
        return maxSize;
    }


    public static void main(String[] args) {
        var m = new MaximizetheConfusionofanExam();
        System.out.println(m.maxConsecutiveAnswers("TTFF", 2));//Output: 4
        System.out.println(m.maxConsecutiveAnswers("TFFT", 1));//Output: 3
        System.out.println(m.maxConsecutiveAnswers("TTFTTFTT", 1));//Output: 5
        System.out.println(m.maxConsecutiveAnswers("F", 1));//
    }
}

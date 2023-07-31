package leetcode._735;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean flag = true;
            while (!stack.isEmpty() && (stack.peek() > 0 && asteroid < 0)) {
                if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    stack.pop();
                    continue;
                } else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    stack.pop();
                }

                flag = false;
                break;
            }
            if (flag) {
                stack.push(asteroid);
            }

        }
        int[] remainingAsteroids = new int[stack.size()];
        for (int i = remainingAsteroids.length - 1; i >= 0; i--) {
            remainingAsteroids[i] = stack.peek();
            stack.pop();
        }
        return remainingAsteroids;
    }


    public static void main(String[] args) {
        var a = new AsteroidCollision();
        System.out.println(Arrays.toString(a.asteroidCollision(new int[]{5, 10, -5})));//Output: [5,10]
        System.out.println(Arrays.toString(a.asteroidCollision(new int[]{8, -8})));//Output: []
        System.out.println(Arrays.toString(a.asteroidCollision(new int[]{10, 2, -5})));//Output: [10]
    }
}

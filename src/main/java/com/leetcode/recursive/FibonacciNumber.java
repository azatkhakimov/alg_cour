package main.java.com.leetcode.recursive;

import java.util.HashMap;
import java.util.Map;

public class FibonacciNumber {
    Map<Integer, Integer> cache = new HashMap<>();
    public int fib(int N){
        if(cache.containsKey(N)){
            return cache.get(N);
        }
        int result;
        if(N < 2){
            result = N;
        }else {
            result = fib(N-1) + fib(N-2);
        }

        cache.put(N, result);
        return result;
    }

    public static void main(String[] args) {
        FibonacciNumber fibonacciNumber = new FibonacciNumber();
//        System.out.println(fibonacciNumber.fib(2));
        System.out.println(fibonacciNumber.fib(4));
    }
}

//package main.java.com.leetcode.array;
//
//import edu.princeton.cs.algs4.In;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class SingleNumber {
//    //    public int singleNumber(int[] nums) {
////        Map<Integer, Integer> map = new HashMap<>();
////        for (int num : nums) {
////            map.put(num, map.getOrDefault(num, 0)+1);
////        }
////        for (Integer integer : map.keySet()) {
////            if(map.get(integer) == 1){
////                return integer;
////            }
////        }
////        return -1;
////    }
//    public int singleNumber(int[] nums) {
//        int result = 0;
//        for (int num : nums) {
//            result ^= num;
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
//        SingleNumber singleNumber = new SingleNumber();
//        System.out.println(singleNumber.singleNumber(new int[]{2, 2, 1}));
//        System.out.println(singleNumber.singleNumber(new int[]{4, 1, 2, 1, 2}));
//        System.out.println(singleNumber.singleNumber(new int[]{1}));
//    }
//}

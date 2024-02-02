package main.java.com.leetcode._2336;

public class SmallestNumberinInfiniteSet {

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        smallestInfiniteSet.addBack(2);    // 2 is already in the set, so no change is made.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 1, since 1 is the smallest number, and remove it from the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 2, and remove it from the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 3, and remove it from the set.
        smallestInfiniteSet.addBack(1);    // 1 is added back to the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 1, since 1 was added back to the set and
        // is the smallest number, and remove it from the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 4, and remove it from the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 5, and remove it from the set.
    }
}

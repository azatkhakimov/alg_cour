package main.java.com.leetcode._779;

public class KthSymbolInGrammar {

    public int kthGrammar(int n, int k) {
        return depthFirstSearch(n, k, 0);
    }

    private int depthFirstSearch(int n, int k, int rootVal) {
        if(n == 1){
            return rootVal;
        }

        int totalNodes = (int) Math.pow(2, n-1);

        if(k > (totalNodes /2)){
            int nextRootVal  = (rootVal == 0) ? 1 : 0;
            return depthFirstSearch(n-1, k-(totalNodes/2), nextRootVal);
        }else {
            int nextRootVal = (rootVal == 0) ? 0 : 1;
            return depthFirstSearch(n-1, k, nextRootVal);
        }
    }

    public static void main(String[] args) {
        var k = new KthSymbolInGrammar();
        System.out.println(k.kthGrammar(1, 1));//Output: 0
        System.out.println(k.kthGrammar(2, 1));//Output: 0
        System.out.println(k.kthGrammar(2, 2));//Output: 1
    }
}

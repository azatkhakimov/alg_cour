package leetcode.recursive;

import java.util.LinkedList;
import java.util.Queue;

public class PrintReverse {
    private void printReverse(char [] str){
        helper(0, str);
    }

    private void helper(int i, char[] str) {
        if(str == null || i >= str.length){
            return;
        }

        helper(i+1, str);
        System.out.println(str[i]);
    }

    public static void main(String[] args) {
        PrintReverse printReverse = new PrintReverse();
        printReverse.printReverse(new char[]{'H', 'E', 'L', 'L', 'O'});
    }
}

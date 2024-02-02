package main.java.com.leetcode._13;

import java.util.HashMap;
import java.util.Map;

public class RomanInteger {
    public int romanToInt(String s) {
        if (s == null) {
            return -1;
        }
        Map<Character, Integer> dict = new HashMap<>();
        dict.put('I', 1);
        dict.put('V', 5);
        dict.put('X', 10);
        dict.put('L', 50);
        dict.put('C', 100);
        dict.put('D', 500);
        dict.put('M', 1000);
        int result = dict.get(s.charAt(s.length()-1));
        for(int i = s.length() -2; i >= 0; i--){
            char current = s.charAt(i);
            char prev = s.charAt(i+1);
            int arabicNumber = dict.get(current);
            int arabicFirst = dict.get(prev);
            if(arabicNumber >= arabicFirst){
                result += arabicNumber;
            }else{
                result -= arabicNumber;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        RomanInteger romanInteger = new RomanInteger();
        System.out.println(romanInteger.romanToInt("LVIII"));//Output: 58
        System.out.println(romanInteger.romanToInt("III"));//Output: 3
        System.out.println(romanInteger.romanToInt("MCMXCIV"));//Output: 1994

    }
}

package leetcode.math;

import java.util.HashMap;
import java.util.Map;

public class RomanInteger {
//    public int romanToInt(String s) {
//        if (s == null) {
//            return -1;
//        }
//        Map<Character, Integer> dict = new HashMap<>();
//        dict.put('I', 1);
//        dict.put('V', 5);
//        dict.put('X', 10);
//        dict.put('L', 50);
//        dict.put('C', 100);
//        dict.put('D', 500);
//        dict.put('M', 1000);
//        int result = dict.get(s.charAt(s.length()-1));
//        for(int i = s.length() -2; i >= 0; i--){
//            char current = s.charAt(i);
//            char prev = s.charAt(i+1);
//            int arabicNumber = dict.get(current);
//            int arabicFirst = dict.get(prev);
//            if(arabicNumber >= arabicFirst){
//                result += arabicNumber;
//            }else{
//                result -= arabicNumber;
//            }
//
//        }
//        return result;
//    }

    public int romanToInt(String S) {
        int ans = 0, num = 0;
        for (int i = S.length()-1; i >= 0; i--) {
            switch(S.charAt(i)) {
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }

    public static void main(String[] args) {
        RomanInteger romanInteger = new RomanInteger();
        int result = romanInteger.romanToInt("LVIII");
        System.out.println(result);

    }
}

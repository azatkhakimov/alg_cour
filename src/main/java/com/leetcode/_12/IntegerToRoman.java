package main.java.com.leetcode._12;
//https://www.youtube.com/watch?v=yzB4M-UXqgI
public class IntegerToRoman {
    private Numeral[] numerals = {
            new Numeral("M", 1000),
            new Numeral("CM", 900),
            new Numeral("D", 500),
            new Numeral("CD", 400),
            new Numeral("C", 100),
            new Numeral("XC", 90),
            new Numeral("L", 50),
            new Numeral("XL", 40),
            new Numeral("X", 10),
            new Numeral("IX", 9),
            new Numeral("V", 5),
            new Numeral("IV", 4),
            new Numeral("I", 1)
    };
    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        for (Numeral numeral : numerals) {
            if(num / numeral.val > 0){
                for(int i = 1; i <= num/numeral.val; i++){
                    res.append(numeral.symbol);
                }
            }
            num %= numeral.val;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        System.out.println(integerToRoman.intToRoman(3));//Output: "III"
        System.out.println(integerToRoman.intToRoman(58));//Output: "LVIII"
        System.out.println(integerToRoman.intToRoman(1994));//Output: "MCMXCIV"
    }
}
class Numeral{
     String symbol;
     int val;

    public Numeral(String symbol, int val) {
        this.symbol = symbol;
        this.val = val;
    }
}

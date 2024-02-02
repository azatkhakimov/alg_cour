package main.java.com.leetcode._2483;

public class MinimumPenaltyforaShop {

    public int bestClosingTime(String customers) {
        int minPenalty = 0;
        int curPenalty = 0;
        int earliestHour = 0;
        for (int i = 0; i < customers.length(); i++) {
            char ch = customers.charAt(i);

            if(ch == 'Y'){
                curPenalty--;
            }else {
                curPenalty++;
            }

            if(curPenalty < minPenalty){
                earliestHour = i + 1;
                minPenalty = curPenalty;
            }
        }
        return earliestHour;
    }

    public static void main(String[] args) {
        var m = new MinimumPenaltyforaShop();
        System.out.println(m.bestClosingTime("YYNY"));//Output: 2
        System.out.println(m.bestClosingTime("NNNNN"));//Output: 0
        System.out.println(m.bestClosingTime( "YYYY"));//Output: 4
    }
}

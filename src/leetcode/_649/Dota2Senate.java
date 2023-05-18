package leetcode._649;

import java.util.LinkedList;
import java.util.Queue;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        int rCount = 0;
        int dCount = 0;
        int dFloatingBan = 0;
        int rFloatingBan = 0;
        Queue<Character> queue = new LinkedList<>();
        for (char c : senate.toCharArray()) {
            queue.add(c);
            if(c == 'R'){
                rCount++;
            }
            else {
                dCount++;
            }
        }
        while (rCount > 0 && dCount > 0){
            char curr = queue.poll();
            if(curr == 'D'){
                if(dFloatingBan > 0){
                    dFloatingBan--;
                    dCount--;
                }else {
                    rFloatingBan++;
                    queue.add('D');
                }
            }else {
                if(rFloatingBan > 0){
                    rFloatingBan--;
                    rCount--;
                }else {
                    dFloatingBan++;
                    queue.add('R');
                }
            }
        }
        return rCount > 0 ? "Radiant" : "Dire";
    }

    public static void main(String[] args) {
        Dota2Senate d = new Dota2Senate();
        System.out.println(d.predictPartyVictory("RD"));//Output: "Radiant"
        System.out.println(d.predictPartyVictory("RDD"));//Output: "Dire"
    }
}

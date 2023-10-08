package leetcode._2038;

public class RemoveColoredPiecesifBothNeighborsaretheSameColor {


    public boolean winnerOfGame(String colors) {
        int alice = 0;
        int bob = 0;
        for (int i = 1; i < colors.length() - 1; i++) {
            if(colors.charAt(i-1) == colors.charAt(i) && colors.charAt(i) == colors.charAt(i+1)){
                if(colors.charAt(i) == 'A'){
                    alice++;
                }else {
                    bob++;
                }
            }
        }
        return alice - bob >= 1;
    }


    public static void main(String[] args) {
        var r = new RemoveColoredPiecesifBothNeighborsaretheSameColor();
        System.out.println(r.winnerOfGame("AAABABB"));//Output: true
        System.out.println(r.winnerOfGame("AA"));//Output: false
        System.out.println(r.winnerOfGame("ABBBBBBBAAA"));//Output: false
    }
}

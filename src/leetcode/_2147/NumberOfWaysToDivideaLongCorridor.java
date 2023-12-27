package leetcode._2147;

public class NumberOfWaysToDivideaLongCorridor {


    public int numberOfWays(String corridor) {
        int MOD = (int) 1e9 + 7;
        int[][] count = new int[corridor.length() + 1][3];

        count[corridor.length()][0] = 0;
        count[corridor.length()][1] = 0;
        count[corridor.length()][2] = 1;

        for (int index = corridor.length() - 1; index >= 0; index--) {
            if (corridor.charAt(index) == 'S') {
                count[index][0] = count[index + 1][1];
                count[index][1] = count[index + 1][2];
                count[index][2] = count[index + 1][1];
            }else {
                count[index][0] = count[index+1][0];
                count[index][1] = count[index+1][1];
                count[index][2] = (count[index+1][0] + count[index+1][2]) % MOD;
            }
        }
        return count[0][0];
    }


    public static void main(String[] args) {
        var n = new NumberOfWaysToDivideaLongCorridor();
        System.out.println(n.numberOfWays("SSPPSPS"));//Output: 3
        System.out.println(n.numberOfWays("PPSPSP"));//Output: 1
        System.out.println(n.numberOfWays("S"));//Output: 0
    }
}

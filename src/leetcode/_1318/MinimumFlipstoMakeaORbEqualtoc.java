package leetcode._1318;

public class MinimumFlipstoMakeaORbEqualtoc {


    public int minFlips(int a, int b, int c) {
        int answer = 0;
        while (a != 0 | b != 0 | c != 0){
            if((c & 1) == 1){
                if((a & 1) == 0 && (b & 1) == 0){
                    answer++;
                }
            }
            else {
                answer += (a & 1) + (b & 1);
            }
            a >>= 1;
            b >>= 1;
            c >>= 1;
        }
        return answer;
    }

    public static void main(String[] args) {
        var m = new MinimumFlipstoMakeaORbEqualtoc();
        System.out.println(m.minFlips(2, 6, 5));//Output: 3
        System.out.println(m.minFlips(4, 2, 7));//Output: 1
        System.out.println(m.minFlips(1, 2, 3));//Output: 0
    }
}

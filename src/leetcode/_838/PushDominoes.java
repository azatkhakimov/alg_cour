package leetcode._838;
//https://www.youtube.com/watch?v=Z2x-zalsebs
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        char[] doms = dominoes.toCharArray();
        int N = dominoes.length();
        int [] forces = new int[N];

        int force = 0;
        for (int i = 0; i < N; i++) {
            if(doms[i] == 'R'){
                force = N;
            }else if(doms[i] == 'L'){
                force = 0;
            }else {
                force = Math.max(force-1, 0);
            }
            forces[i] += force;
        }
        force = 0;
        for (int i = N-1; i >= 0; i--) {
            if(doms[i] == 'L'){
                force = N;
            }else if(doms[i] == 'R'){
                force = 0;
            }else {
                force = Math.max(force-1, 0);
            }
            forces[i] -= force;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < forces.length; i++) {
            if(forces[i] > 0){
                stringBuilder.append("R");
            }else if(forces[i] < 0){
                stringBuilder.append("L");
            }else {
                stringBuilder.append(".");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        PushDominoes pushDominoes = new PushDominoes();
        System.out.println(pushDominoes.pushDominoes("RR.L"));//Output: "RR.L"
        System.out.println(pushDominoes.pushDominoes(".L.R...LR..L.."));//Output: "LL.RR.LLRRLL.."
    }
}

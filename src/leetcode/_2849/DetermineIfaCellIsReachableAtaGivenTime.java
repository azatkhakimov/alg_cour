package leetcode._2849;

public class DetermineIfaCellIsReachableAtaGivenTime {


    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        int width = Math.abs(sx-fx);
        int height = Math.abs(sy-fy);

        if(width == 0 && height == 0 && t == 1){
            return false;
        }
        return t >= Math.max(width, height);
    }


    public static void main(String[] args) {
        var d = new DetermineIfaCellIsReachableAtaGivenTime();
        System.out.println(d.isReachableAtTime(2, 4, 7, 7, 6));//Output: true
        System.out.println(d.isReachableAtTime(3, 1, 7, 3, 3));//Output: false

    }
}

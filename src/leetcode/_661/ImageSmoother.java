package leetcode._661;

import java.util.Arrays;

public class ImageSmoother {

    public int[][] imageSmoother(int[][] img) {
        int m = img.length;
        int n = img[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                int count = 0;

                for (int x = i-1; x <= i+1; x++) {
                    for (int y = j-1; y <= j+1; y++) {
                        if(0 <= x && x < m && 0 <= y && y< n){
                            sum+=img[x][y] % 256;
                            count+=1;
                        }
                    }
                }
                img[i][j] += (sum / count) * 256;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                img[i][j] /= 256;
            }
        }
        return img;
    }


    public static void main(String[] args) {
        var i = new ImageSmoother();
        System.out.println(Arrays.deepToString(i.imageSmoother(new int[][]{{1,1,1},{1,0,1},{1,1,1}})));//Output: [[0,0,0],[0,0,0],[0,0,0]]
        System.out.println(Arrays.deepToString(i.imageSmoother(new int[][]{{100,200,100},{200,50,200},{100,200,100}})));//Output: [[137,141,137],[141,138,141],[137,141,137]]
    }
}

package leetcode._835;

public class ImageOverlap {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int overlapRes = 0;
        for(int row = -img1.length+1; row < img1.length; row++){
            for (int col = -img1[0].length+1; col < img1[0].length; col++){
                overlapRes = Math.max(overlapRes, overlap(img1, img2, row, col));
            }
        }
        return overlapRes;
    }

    private int overlap(int[][] img1, int[][] img2, int rowOffset, int colOffset) {
        int count = 0;
        for(int row = 0; row < img1.length; row++){
            for(int col = 0; col < img1[row].length; col++){
                if(row + rowOffset < 0 || row+rowOffset >= img1.length){
                    continue;
                }
                if(col + colOffset < 0 || col + colOffset >= img1[0].length){
                    continue;
                }
                if(img1[row][col] + img2[row+rowOffset][col+colOffset] == 2){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ImageOverlap imageOverlap = new ImageOverlap();
        System.out.println(imageOverlap.largestOverlap(
                new int[][]{{1}},
                new int[][]{{1}}
        ));//Output: 1
        System.out.println(imageOverlap.largestOverlap(
                new int[][]{{0}},
                new int[][]{{0}}
        ));//Output: 0

        System.out.println(imageOverlap.largestOverlap(
                new int[][]{
                        {1,1,0},
                        {0,1,0},
                        {0,1,0}
                },
                new int[][]{
                        {0,0,0},
                        {0,1,1},
                        {0,0,1}
                }
        ));//Output: 3
    }
}

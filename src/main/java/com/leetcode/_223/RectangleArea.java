package main.java.com.leetcode._223;

public class RectangleArea {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int areaOfSquare1 = (ax2-ax1) * (ay2-ay1);
        int areaOFSquare2 = (bx2-bx1) * (by2-by1);

        int left = Math.max(ax1, bx1);
        int right = Math.min(ax2, bx2);
        int bottom = Math.max(ay1, by1);
        int top = Math.min(ay2, by2);

        int overlap = 0;
        if(right > left && top > bottom){
            overlap = (right-left) * (top-bottom);
        }
        return areaOfSquare1 + areaOFSquare2 - overlap;
    }

    public static void main(String[] args) {
        RectangleArea rectangleArea = new RectangleArea();
        System.out.println(rectangleArea.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));//Output: 45
        System.out.println(rectangleArea.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));//Output: 16
    }
}

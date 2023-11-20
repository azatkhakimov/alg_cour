package leetcode._1441;

import java.util.ArrayList;
import java.util.List;

public class BuildAnArrayWithStackOperations {

    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        int i = 0;
        for (int num : target) {
            while (i < num - 1) {
                ans.add("Push");
                ans.add("Pop");
                i++;
            }
            ans.add("Push");
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        var b = new BuildAnArrayWithStackOperations();
        System.out.println(b.buildArray(new int[]{1, 3}, 3));//Output: ["Push","Push","Pop","Push"]
        System.out.println(b.buildArray(new int[]{1, 2, 3}, 3));//Output: ["Push","Push","Push"]
        System.out.println(b.buildArray(new int[]{1, 2}, 4));//Output: ["Push","Push"]

    }
}

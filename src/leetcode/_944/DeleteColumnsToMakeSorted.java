package leetcode._944;

public class DeleteColumnsToMakeSorted {

    public int minDeletionSize(String[] strs) {
        int K = strs[0].length();

        int ans = 0;
        for (int col = 0; col < K; col++) {
            for (int row = 1; row < strs.length; row++) {
                if(strs[row].charAt(col) < strs[row-1].charAt(col)){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DeleteColumnsToMakeSorted column = new DeleteColumnsToMakeSorted();
        System.out.println(column.minDeletionSize(new String[]{"cba","daf","ghi"}));//Output: 1
        System.out.println(column.minDeletionSize(new String[]{"a","b"}));//Output: 0
        System.out.println(column.minDeletionSize(new String[]{"zyx","wvu","tsr"}));//Output: 3
    }
}

package leetcode._1601;

public class MaximumNumberofAchievableTransferRequests {

    private int answer = 0;

    public int maximumRequests(int n, int[][] requests) {
        int[] indegree = new int[n];
        maxRequests(requests, indegree, n, 0, 0);
        return answer;
    }

    private void maxRequests(int[][] requests, int[] indegree, int n, int index, int count) {
        if(index == requests.length){
            for (int i = 0; i < n; i++) {
                if(indegree[i] != 0){
                    return;
                }
            }
            answer = Math.max(answer, count);
            return;
        }
        indegree[requests[index][0]]--;
        indegree[requests[index][1]]++;
        maxRequests(requests, indegree, n, index+1, count+1);

        indegree[requests[index][0]]++;
        indegree[requests[index][1]]--;

        maxRequests(requests, indegree, n, index+1, count);
    }

    public static void main(String[] args) {
        var m = new MaximumNumberofAchievableTransferRequests();
        System.out.println(m.maximumRequests(5,
                new int[][]{{0, 1}, {1, 0}, {0, 1}, {1, 2}, {2, 0}, {3, 4}}));//Output: 5
        System.out.println(m.maximumRequests(3,
                new int[][]{{0, 0}, {1, 2}, {2, 1}}));//Output: 3
        System.out.println(m.maximumRequests(4,
                new int[][]{{0, 3}, {3, 1}, {1, 2}, {2, 0}}));//Output: 4
    }
}

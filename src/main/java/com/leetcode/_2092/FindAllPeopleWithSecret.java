package main.java.com.leetcode._2092;

import java.util.*;

public class FindAllPeopleWithSecret {

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] meeting : meetings) {
            int x = meeting[0];
            int y = meeting[1];
            int time = meeting[2];
            graph.computeIfAbsent(x, k -> new ArrayList<>()).add(new int[]{time, y});
            graph.computeIfAbsent(y, k -> new ArrayList<>()).add(new int[]{time, x});
        }

        int[] earliest = new int[n];
        Arrays.fill(earliest, Integer.MAX_VALUE);
        earliest[0] = 0;
        earliest[firstPerson] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        q.offer(new int[]{firstPerson, 0});

        while (!q.isEmpty()) {
            int[] personTime = q.poll();
            int person = personTime[0];
            int time = personTime[1];
            for (int[] nextPersonTime : graph.getOrDefault(person, new ArrayList<>())) {
                int t = nextPersonTime[0];
                int nextPerson = nextPersonTime[1];
                if(t >= time && earliest[nextPerson] > t){
                    earliest[nextPerson]  = t;
                    q.offer(new int[]{nextPerson, t});
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(earliest[i] != Integer.MAX_VALUE){
                ans.add(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        var f = new FindAllPeopleWithSecret();
        System.out.println(f.findAllPeople(6, new int[][]{{1, 2, 5}, {2, 3, 8}, {1, 5, 10}}, 1));//Output: [0,1,2,3,5]
        System.out.println(f.findAllPeople(4, new int[][]{{3, 1, 3}, {1, 2, 2}, {0, 3, 3}}, 3));//Output: [0,1,3]
        System.out.println(f.findAllPeople( 5, new int[][] {{3,4,2},{1,2,1},{2,3,1}},  1));//Output: [0,1,2,3,4]
    }
}

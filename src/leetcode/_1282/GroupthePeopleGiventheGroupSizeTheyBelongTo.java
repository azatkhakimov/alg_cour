package leetcode._1282;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupthePeopleGiventheGroupSizeTheyBelongTo {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> szToGroup = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            if(!szToGroup.containsKey(groupSizes[i])){
                szToGroup.put(groupSizes[i], new ArrayList<>());
            }

            List<Integer> group = szToGroup.get(groupSizes[i]);
            group.add(i);

            if(group.size() == groupSizes[i]){
                ans.add(group);
                szToGroup.remove(groupSizes[i]);
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        var g = new GroupthePeopleGiventheGroupSizeTheyBelongTo();
        System.out.println(g.groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3}));//Output: [[5],[0,1,2],[3,4,6]]
        System.out.println(g.groupThePeople(new int[]{2, 1, 3, 3, 3, 2}));//Output: [[1],[0,5],[2,3,4]]
    }
}

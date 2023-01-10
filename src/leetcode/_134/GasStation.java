package leetcode._134;

//https://leetcode.com/problems/gas-station/solutions/1706142/java-c-python-an-explanation-that-ever-exists-till-now/?orderBy=most_votes
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int total = 0;
        int surplus = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            total += gas[i]-cost[i];
            surplus += gas[i] - cost[i];
            if(surplus < 0){
                surplus = 0;
                start = i+1;
            }
        }
        return total < 0 ? -1 : start;
    }



    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        System.out.println(gasStation.canCompleteCircuit(new int[]{1,2,3,4,5}, new int[]{3,4,5,1,2}));//Output: 3
        System.out.println(gasStation.canCompleteCircuit(new int[]{2,3,4}, new int[]{3,4,3}));//Output: -1
    }
}

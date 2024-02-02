package leetcode._134;

//https://leetcode.com/problems/gas-station/solutions/1706142/java-c-python-an-explanation-that-ever-exists-till-now/?orderBy=most_votes
public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;
        for (int i : gas) {
            totalGas += i;
        }
        for (int i : cost) {
            totalCost += i;
        }
        if (totalGas < totalCost) {
            return -1;
        }

        int curGas = 0;
        int idx = 0;
        for (int i = 0; i < gas.length; i++) {
            curGas += gas[i] - cost[i];
            if (curGas < 0) {
                curGas = 0;
                idx = i + 1;
            }

        }
        return idx;
    }


    public static void main(String[] args) {
        GasStation gasStation = new GasStation();
        System.out.println(gasStation.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));//Output: 3
        System.out.println(gasStation.canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));//Output: -1
    }
}

package leetcode._1359;

public class CountAllValidPickupandDeliveryOptions {


    public int countOrders(int n) {
        long res = 1;
        long mod = (long) 1e9 + 7;
        for (int i = 1; i <= n; i++) {
            res = res * (i * 2 - 1) * i % mod;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        var c = new CountAllValidPickupandDeliveryOptions();
        System.out.println(c.countOrders(1));//Output: 1
        System.out.println(c.countOrders(2));//Output: 6
        System.out.println(c.countOrders(3));//Output: 90
    }
}

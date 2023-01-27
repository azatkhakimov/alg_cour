package leetcode._319;

public class BulbSwitcher {


    public int bulbSwitch(int n) {
        return (int)Math.sqrt(n);
    }

    public static void main(String[] args) {
        BulbSwitcher b = new BulbSwitcher();
        System.out.println(b.bulbSwitch(3));//Output: 1
        System.out.println(b.bulbSwitch(0));//Output: 0
        System.out.println(b.bulbSwitch(1));//Input: n = 1
    }
}

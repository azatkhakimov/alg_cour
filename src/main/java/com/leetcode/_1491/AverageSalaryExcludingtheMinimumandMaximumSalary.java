package main.java.com.leetcode._1491;

public class AverageSalaryExcludingtheMinimumandMaximumSalary {

    public double average(int[] salary) {
        int total = 0;
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;
        for (int sal : salary) {
            total += sal;
            minSalary = Math.min(minSalary, sal);
            maxSalary  = Math.max(maxSalary, sal);
        }
        return (double)(total - minSalary - maxSalary) / (double)(salary.length-2);
    }

    public static void main(String[] args) {
        AverageSalaryExcludingtheMinimumandMaximumSalary a = new AverageSalaryExcludingtheMinimumandMaximumSalary();
        System.out.println(a.average(new int[]{4000,3000,1000,2000}));//Output: 2500.00000
        System.out.println(a.average(new int[]{1000,2000,3000}));//Output: 2000.00000
    }
}

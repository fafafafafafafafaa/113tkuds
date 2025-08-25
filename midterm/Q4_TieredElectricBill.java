import java.util.*;

public class Q4_TieredElectricBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] bills = new long[n];
        long total = 0;

        for (int i = 0; i < n; i++) {
            int kWh = sc.nextInt();
            bills[i] = Math.round(calcBill(kWh));
            total += bills[i];
        }

        for (long bill : bills) {
            System.out.println("Bill: $" + bill);
        }
        System.out.println("Total: $" + total);
        System.out.println("Average: $" + Math.round((double) total / n));

        sc.close();
    }

    // 計算單一用戶電費（未四捨五入）
    private static double calcBill(int kWh) {
        double cost = 0;
        int remaining = kWh;

        int[] limits = {120, 330, 500, 700, 1000};
        double[] rates = {1.68, 2.45, 3.70, 5.04, 6.24};
        // 前五個區間
        for (int i = 0; i < limits.length; i++) {
            int use = Math.min(remaining, (i == 0 ? limits[i] : limits[i] - limits[i - 1]));
            cost += use * rates[i];
            remaining -= use;
            if (remaining <= 0) {
                return cost;
            }
        }
        // 超過 1000
        cost += remaining * 8.46;
        return cost;
    }
}

// Time Complexity: O(n)

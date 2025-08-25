import java.util.*;

public class F04_TieredIncomeTax {

    // 根據 2025 台灣綜所稅級距計算稅額
    // 時間複雜度：O(1)（固定5個稅率區間，不隨輸入變化）
    // 空間複雜度：O(1)（只用常數大小的額外空間）
    public static int computeTax(int income) {
        int tax = 0;
        int[][] brackets = {
            {0,      560000,  5},
            {560001, 1260000, 12},
            {1260001,2520000, 20},
            {2520001,4720000, 30},
            {4720001,Integer.MAX_VALUE, 40}
        };

        for (int[] b : brackets) {
            int lower = b[0];
            int upper = b[1];
            int rate = b[2];

            if (income > upper) {
                tax += (upper - lower + 1) * rate / 100;
            } else {
                tax += (income - lower + 1) * rate / 100;
                break;
            }
        }

        return tax;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());  // 輸入人數 n
        int[] incomes = new int[n];

        // 讀入 n 筆收入資料，時間複雜度 O(n)，空間 O(n)
        for (int i = 0; i < n; i++) {
            incomes[i] = Integer.parseInt(sc.nextLine());
        }

        int totalTax = 0;

        // 計算每筆收入稅額並輸出，時間複雜度 O(n)，
        // 因為 computeTax 為 O(1)，整體為 O(n)
        for (int i = 0; i < n; i++) {
            int tax = computeTax(incomes[i]);
            totalTax += tax;
            System.out.println("Tax: $" + tax);
        }

        // 輸出平均稅額，時間 O(1)
        System.out.printf("Average: $%.0f\n", (double) totalTax / n);

        sc.close();
    }
}

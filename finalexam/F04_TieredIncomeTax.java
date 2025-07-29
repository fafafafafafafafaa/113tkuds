import java.util.*;

public class F04_TieredIncomeTax {

    // 根據 2025 台灣綜所稅級距計算稅額
    public static int computeTax(int income) {
        int tax = 0;
        int[][] brackets = {
            {0,      560000,  5},
            {560001, 1260000, 12},
            {1260001,2520000, 20},
            {2520001,4720000, 30},
            {4720001,Integer.MAX_VALUE, 40}
        };

        int prevUpper = 0;

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

        int n = Integer.parseInt(sc.nextLine());
        int[] incomes = new int[n];
        int totalTax = 0;

        for (int i = 0; i < n; i++) {
            incomes[i] = Integer.parseInt(sc.nextLine());
        }

        for (int i = 0; i < n; i++) {
            int tax = computeTax(incomes[i]);
            totalTax += tax;
            System.out.println("Tax: $" + tax);
        }

        System.out.printf("Average: $%.0f\n", (double) totalTax / n);

        
    }
}

// 檔名：q1arraysum.java
import java.util.Scanner;

public class q1arraysum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀取整數 n
        int n = sc.nextInt();
        int sum = 0;

        // 讀取 n 個整數並加總
        for (int i = 0; i < n; i++) {
            int number = sc.nextInt();
            sum += number;
        }

        // 輸出總和
        System.out.println(sum);
        // 輸出 n（ops）
        System.out.println(n);

        sc.close(); // 關閉 Scanner
    }
}

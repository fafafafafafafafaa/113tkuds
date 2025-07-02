// 檔名：q1arraysum.java
import java.util.Scanner;

public class q1arraysum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示使用者輸入整數數量
        System.out.print("請輸入整數數量 n：");
        int n = scanner.nextInt();
        int total = 0;

        // 提示輸入 n 個整數
        System.out.println("請輸入 " + n + " 個整數：");
        for (int i = 1; i <= n; i++) {
            System.out.print("第 " + i + " 個數：");
            int num = scanner.nextInt();
            total += num;
        }

        // 輸出總和與輸入的數量
        System.out.println("整數總和為：" + total);
        System.out.println("輸入的整數數量為：" + n);

        scanner.close(); // 關閉輸入
    }
}

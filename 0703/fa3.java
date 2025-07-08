import java.util.Scanner;

public class fa3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);         // 建立 Scanner 物件讀取輸入
        String line = sc.nextLine().trim();          // 讀取一整行輸入並去除前後空白
        sc.close();                                  // 關閉 Scanner

        String[] parts = line.split(" ");            // 以空格分割字串
        int a = Integer.parseInt(parts[0]);          // 解析第一個整數
        int b = Integer.parseInt(parts[1]);          // 解析第二個整數

        int sum = a + b;                             // 計算總和
        System.out.println(sum);                     // 輸出總和
    }
}
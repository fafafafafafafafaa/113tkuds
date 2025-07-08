import java.util.Scanner;

public class fa2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 讀入變數 n
        int result = ((n + n) + (n * 5));  // 計算 ((n+n)+(n*5))
        System.out.println(result);  // 輸出結果
        sc.close();
    }
}

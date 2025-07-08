import java.util.Scanner;

public class fa5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀入攝氏溫度
        int celsius = sc.nextInt();

        // 計算華氏溫度
        int fahrenheit = (celsius * 9 / 5) + 32;

        // 輸出結果
        System.out.println(fahrenheit);

        sc.close();
    }
}

import java.util.Scanner;

public class fa2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 使用者輸入 n，例如 8
        int result = ((n + n) + (n * 5)) - 2;
        System.out.println(result); // 輸出結果 54
        sc.close();
    }
}

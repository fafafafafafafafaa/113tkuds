import java.util.Scanner;

public class fa6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();  // 讀取金字塔高度

        // 外層迴圈：處理每一行 i
        for (int i = 1; i <= N; i++) {
            StringBuilder line = new StringBuilder();

            // 遞增部分：1, 2, ..., i
            for (int j = 1; j <= i; j++) {
                line.append(j).append(" ");
            }

            // 遞減部分：i-1, i-2, ..., 1
            for (int j = i - 1; j >= 1; j--) {
                line.append(j).append(" ");
            }

            // 去除尾部多餘空格後輸出
            System.out.println(line.toString().trim());
        }

        scanner.close();  // 關閉 Scanner
    }
}

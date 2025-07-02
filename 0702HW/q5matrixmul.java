import java.util.Scanner;

public class q5matrixmul {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] A = new int[n][n];
        int[][] B = new int[n][n];

        // 讀取矩陣 A
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                A[i][j] = sc.nextInt();
            }
        }

        // 讀取矩陣 B
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                B[i][j] = sc.nextInt();
            }
        }

        int[][] C = new int[n][n];

        int mulCount = 0;
        int addCount = 0;

        // 矩陣乘法
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = 0;
                for (int k = 0; k < n; k++) {
                    sum += A[i][k] * B[k][j];
                    mulCount++;  // 每次乘法計數
                    if (k > 0) {
                        addCount++;  // 除了第一個乘法外，其餘都是加法
                    }
                }
                C[i][j] = sum;
            }
        }

        // 輸出結果矩陣
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(C[i][j]);
                if (j != n - 1) System.out.print(" ");
            }
            System.out.println();
        }

        // 輸出操作次數 (乘法 + 加法)
        System.out.println(mulCount + addCount);

        sc.close();
    }
}

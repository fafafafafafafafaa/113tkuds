import java.util.Scanner;

public class q4paircount {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀取陣列長度 n
        int n = sc.nextInt();
        int[] arr = new int[n];

        // 讀取陣列元素（題意要求讀取，但未用於計算）
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int pairCount = 0;
        int ops = 0;

        // 雙層迴圈計算不同索引的成對數量
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                pairCount++;
                ops++;  // 每配對計為一次操作
            }
        }

        // 輸出配對數與操作次數
        System.out.println(pairCount);
        System.out.println(ops);

        sc.close();
    }
}

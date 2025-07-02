import java.util.Scanner;

public class q2seqsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀取陣列長度 n
        int n = sc.nextInt();
        int[] arr = new int[n];

        // 讀取 n 個整數
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 讀取要搜尋的 key
        int key = sc.nextInt();

        // 執行線性搜尋，記錄操作次數
        boolean found = false;
        int count = 0;  // 紀錄實際比對次數

        for (int i = 0; i < n; i++) {
            count++;
            if (arr[i] == key) {
                found = true;
                break;
            }
        }

        // 輸出搜尋結果
        System.out.println(found ? "Yes" : "No");

        // 輸出實際搜尋次數（操作次數）
        System.out.println(count);

        sc.close();
    }
}


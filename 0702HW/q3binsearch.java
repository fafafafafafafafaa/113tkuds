import java.util.Scanner;

public class q3binsearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 讀取陣列長度
        int n = sc.nextInt();
        int[] arr = new int[n];

        // 讀取已排序陣列
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 讀取搜尋的 key
        int key = sc.nextInt();

        // 執行二分搜尋
        int left = 0;
        int right = n - 1;
        int index = -1;
        int ops = 0; // 比較次數

        while (left <= right) {
            ops++;
            int mid = (left + right) / 2;

            if (arr[mid] == key) {
                index = mid;
                break;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // 輸出結果
        System.out.println(index);
        System.out.println(ops);

        sc.close();
    }
}


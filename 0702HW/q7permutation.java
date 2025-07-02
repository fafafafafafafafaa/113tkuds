import java.util.Scanner;

public class q7permutation {
    static int ops = 0; // 計算遞迴呼叫次數

    public static void permute(int[] arr, int start, int n) {
        ops++; // 每次呼叫 permute 都算一次操作

        if (start == n) {
            // 輸出一組排列
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]);
                if (i < n -1) System.out.print(" ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < n; i++) {
            swap(arr, start, i);
            permute(arr, start + 1, n);
            swap(arr, start, i); // 還原
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        // 初始化陣列 1, 2, ..., n
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }

        permute(arr, 0, n);

        System.out.println(ops);

        sc.close();
    }
}

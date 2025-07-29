import java.util.*;

public class F06_ArraySecondLargest {

    /**
     * 使用分治法尋找最大值和第二大值
     * @param arr 陣列
     * @param left 左邊索引
     * @param right 右邊索引
     * @return 長度為2的陣列，result[0] = 最大值, result[1] = 第二大值
     * 
     * 時間複雜度：O(n)
     * - 雖然是分治，每層切成兩半，但每層合併過程只做常數時間比較，
     *   且總共有 log n 層，總合約為 O(n)
     * 
     * 空間複雜度：O(log n)
     * - 遞迴呼叫堆疊深度約為 log n
     */
    public static int[] findSecondMax(int[] arr, int left, int right) {
        if (left == right) {
            // 只有一個元素，最大是該值，第二大不存在
            return new int[]{arr[left], Integer.MIN_VALUE};
        }

        int mid = (left + right) / 2;
        int[] leftPair = findSecondMax(arr, left, mid);
        int[] rightPair = findSecondMax(arr, mid + 1, right);

        int max, second;

        // 合併左右兩邊結果，更新最大和第二大
        if (leftPair[0] > rightPair[0]) {
            max = leftPair[0];
            // 第二大是左邊次大與右邊最大中的較大者
            second = Math.max(leftPair[1], rightPair[0]);
        } else {
            max = rightPair[0];
            // 第二大是右邊次大與左邊最大中的較大者
            second = Math.max(rightPair[1], leftPair[0]);
        }

        return new int[]{max, second};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];

        String[] tokens = sc.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokens[i]);
        }

        int[] result = findSecondMax(arr, 0, n - 1);
        System.out.println("SecondMax: " + result[1]);
    }
}

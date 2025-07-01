public class array_sum_trace {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5};  // 固定陣列值
        int total = 0;

        // 加總陣列中的每個元素，並印出加總過程
        for (int i = 0; i < arr.length; i++) {
            System.out.println("加總過程：total = " + total + " + " + arr[i] + " = " + (total + arr[i]));
            total += arr[i];
        }

        System.out.println("總和為：" + total);
    }
}

/*
 * 時間複雜度說明：
 * 這個演算法會對陣列中每一個元素做一次加總與輸出。
 * 如果陣列長度是 n，就會跑 n 次迴圈，
 * 每次迴圈都只做固定的操作（加法與印出），所以整體效率是線性的。
 *
 * 因此，時間複雜度為：O(n)
 * n 為陣列的元素個數。
 */

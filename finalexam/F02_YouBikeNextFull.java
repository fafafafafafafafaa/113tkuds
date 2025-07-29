import java.util.*;

public class F02_YouBikeNextFull {
    // 時間字串轉換成總分鐘數
    public static int toMinutes(String time) {
        String[] parts = time.split(":");
        int h = Integer.parseInt(parts[0]);
        int m = Integer.parseInt(parts[1]);
        return h * 60 + m;
    }

    // 分鐘數轉換回時間字串
    public static String toTimeString(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        int[] schedule = new int[n];

        // 輸入時間表，並轉成分鐘存入陣列
        for (int i = 0; i < n; i++) {
            schedule[i] = toMinutes(sc.nextLine());
        }

        int query = toMinutes(sc.nextLine());

        // 二分搜尋找第一個大於 query 的時間
        int left = 0, right = n - 1;
        int answerIndex = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (schedule[mid] > query) {
                answerIndex = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        if (answerIndex == -1) {
            System.out.println("No bike");
        } else {
            System.out.println(toTimeString(schedule[answerIndex]));
        }

        // -------- 計算複雜度註解 --------
        /*
         * 時間複雜度（Time Complexity）：
         * - 時間轉換（n 筆）：O(n)
         * - 二分搜尋：O(log n)
         * => 總時間複雜度：O(n + log n)

         * 空間複雜度（Space Complexity）：
         * - 儲存 n 筆時間資料：O(n)
         * => 總空間複雜度：O(n)
         */
    }
}

import java.util.*;

public class F01_TMRTStopCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            // 讀取站數
            int n = Integer.parseInt(sc.nextLine().trim());

            // 讀取 n 個站名
            String[] stations = sc.nextLine().trim().split("\\s+");
            if (stations.length != n) {
                System.out.println("Invalid");
                return;
            }

            // 讀取起點與終點站
            String[] startEnd = sc.nextLine().trim().split("\\s+");
            if (startEnd.length != 2) {
                System.out.println("Invalid");
                return;
            }

            String start = startEnd[0];
            String end = startEnd[1];

            // 找出 start 和 end 的索引
            int startIndex = -1;
            int endIndex = -1;

            for (int i = 0; i < n; i++) {
                if (stations[i].equals(start)) {
                    startIndex = i;
                }
                if (stations[i].equals(end)) {
                    endIndex = i;
                }
            }

            if (startIndex == -1 || endIndex == -1) {
                System.out.println("Invalid");
            } else {
                int stopCount = Math.abs(startIndex - endIndex) + 1;
                System.out.println(stopCount);
            }

        } catch (Exception e) {
            System.out.println("Invalid");
        }

        sc.close();
    }
}

/*
    🔍 計算複雜度分析：
    - 掃描所有站找起訖索引：O(n)
    - 其他操作（字串分割、比較、加減）：O(1)
    👉 總時間複雜度：O(n)
*/

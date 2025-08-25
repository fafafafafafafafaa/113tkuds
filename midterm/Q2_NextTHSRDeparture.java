import java.util.*;

public class Q2_NextTHSRDeparture {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] times = new int[n];
        sc.nextLine();  // 吃掉換行

        for (int i = 0; i < n; i++) {
            String timeStr = sc.nextLine();
            times[i] = parseTimeToMinutes(timeStr);
        }

        String queryStr = sc.nextLine();
        int query = parseTimeToMinutes(queryStr);

        int idx = binarySearch(times, query);

        if (idx == n) {
            System.out.println("No train");
        } else {
            System.out.println(formatMinutesToTime(times[idx]));
        }

        sc.close();
    }

    private static int parseTimeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    private static String formatMinutesToTime(int minutes) {
        int h = minutes / 60;
        int m = minutes % 60;
        return String.format("%02d:%02d", h, m);
    }

    private static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

// Time Complexity: O(log n)
-
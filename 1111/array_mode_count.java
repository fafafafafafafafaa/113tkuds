public class array_mode_count {
    public static void main(String[] args) {
        int[] arr = {3, 7, 3, 1, 1, 1};
        int mode = arr[0];    // 初始眾數
        int maxCount = 0;     // 最大次數

        for (int i = 0; i < arr.length; i++) {
            int current = arr[i];
            int count = 0;

            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == current) {
                    count++;
                }
            }

            System.out.println("比對中：" + current + " 出現次數 = " + count);

            if (count > maxCount) {
                maxCount = count;
                mode = current;
            }
        }

        System.out.println("眾數為：" + mode + "，出現 " + maxCount + " 次");
    }
}


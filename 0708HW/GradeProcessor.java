public class GradeProcessor {
    public static void main(String[] args) {
        // 1. 建立一個成績陣列，裡面放 8 位學生的分數
        int[] scores = {78, 85, 92, 67, 88, 95, 73, 90};

        // 2. 計算所有分數的總和與平均分數
        int sum = 0;
        for (int score : scores) { // 用加強版 for 迴圈，把每個分數加起來
            sum += score;
        }
        double average = (double) sum / scores.length; // 計算平均，記得轉成 double

        // 印出成績統計資料
        System.out.println("=== 成績統計報表 ===");
        System.out.println("學生人數：" + scores.length + " 人");
        System.out.println("總分：" + sum + " 分");
        System.out.printf("平均分數：%.2f 分\n", average); // 保留兩位小數輸出

        // 3. 找出最高分和最低分，還有他們的位置（索引）
        int max = scores[0], min = scores[0]; // 先把第一個分數當作最高和最低
        int maxIndex = 0, minIndex = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) { // 找到更高分就更新最高分和索引
                max = scores[i];
                maxIndex = i;
            }
            if (scores[i] < min) { // 找到更低分就更新最低分和索引
                min = scores[i];
                minIndex = i;
            }
        }
        System.out.println("最高分：" + max + " 分（第 " + (maxIndex + 1) + " 位學生）");
        System.out.println("最低分：" + min + " 分（第 " + (minIndex + 1) + " 位學生）");

        // 4. 計算有多少學生的分數超過平均分
        int countAboveAverage = 0;
        for (int score : scores) {
            if (score > average) {
                countAboveAverage++;
            }
        }
        System.out.println("超過平均分數人數：" + countAboveAverage + " 人");

        // 5. 印出每位學生的分數
        System.out.println("\n個別成績：");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("第 " + (i + 1) + " 位學生：" + scores[i] + " 分");
        }
    }
}
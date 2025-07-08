public class GradeProcessor {
    public static void main(String[] args) {
        // 1. 建立成績陣列（8 位學生的分數）
        int[] scores = {78, 85, 92, 67, 88, 95, 73, 90};

        // 2. 計算總分與平均分數
        int sum = 0;
        for (int score : scores) { // 用增強型 for 迴圈加總
            sum += score;
        }
        double average = (double) sum / scores.length; // 平均要轉型為 double

        // 輸出總分與平均分（保留兩位小數）
        System.out.println("=== 成績統計報表 ===");
        System.out.println("學生人數：" + scores.length + " 人");
        System.out.println("總分：" + sum + " 分");
        System.out.printf("平均分數：%.2f 分\n", average);

        // 3. 找出最高分和最低分，以及對應的學生索引
        int max = scores[0], min = scores[0]; // 初始設為第一個成績
        int maxIndex = 0, minIndex = 0;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] > max) {
                max = scores[i];
                maxIndex = i;
            }
            if (scores[i] < min) {
                min = scores[i];
                minIndex = i;
            }
        }
        System.out.println("最高分：" + max + " 分（第 " + (maxIndex + 1) + " 位學生）");
        System.out.println("最低分：" + min + " 分（第 " + (minIndex + 1) + " 位學生）");

        // 4. 統計有幾位學生分數高於平均
        int countAboveAverage = 0;
        for (int score : scores) {
            if (score > average) {
                countAboveAverage++;
            }
        }
        System.out.println("超過平均分數人數：" + countAboveAverage + " 人");

        // 5. 輸出每位學生的成績
        System.out.println("\n個別成績：");
        for (int i = 0; i < scores.length; i++) {
            System.out.println("第 " + (i + 1) + " 位學生：" + scores[i] + " 分");
        }
    }
}

import java.util.Scanner;

public class ScoreReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int studentCount = 10;
        int[] scores = new int[studentCount];
        int total = 0;

        // 輸入成績
        for (int i = 0; i < studentCount; i++) {
            System.out.printf("請輸入第 %d 位學生的成績：", i + 1);
            scores[i] = sc.nextInt();
            total += scores[i];
        }

        double average = (double) total / studentCount;

        // 印出報表
        System.out.println("\n===　成績統計報表　===");
        System.out.printf("學生人數：%2d 人\n", studentCount);
        System.out.printf("總分　　：%3d 分\n", total);
        System.out.printf("平均分數：%.2f 分\n", average);
        System.out.println("\n個別成績：");

        for (int i = 0; i < studentCount; i++) {
            System.out.printf("第 %2d 位學生：%3d 分\n", i + 1, scores[i]);
        }

        sc.close();
    }
}

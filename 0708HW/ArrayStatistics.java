public class ArrayStatistics {
    public static void main(String[] args) {
        // 1. 建立陣列
        int[] numbers = {5, 12, 8, 15, 7, 23, 18, 9, 14, 6};

        // 總和與平均值
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        double average = (double) sum / numbers.length;

        // 最大值、最小值及其索引位置
        int max = numbers[0], min = numbers[0];
        int maxIndex = 0, minIndex = 0;

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
                maxIndex = i;
            }
            if (numbers[i] < min) {
                min = numbers[i];
                minIndex = i;
            }
        }

        // 計算大於平均值的個數
        int countAboveAverage = 0;
        for (int num : numbers) {
            if (num > average) {
                countAboveAverage++;
            }
        }

        // 計算偶數與奇數的個數
        int evenCount = 0, oddCount = 0;
        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        // 3. 輸出結果（表格形式）
        System.out.println("======= 陣列統計分析 =======");
        System.out.printf("%-15s: %d\n", "總和", sum);
        System.out.printf("%-15s: %.2f\n", "平均值", average);
        System.out.printf("%-15s: %d (索引 %d)\n", "最大值", max, maxIndex);
        System.out.printf("%-15s: %d (索引 %d)\n", "最小值", min, minIndex);
        System.out.printf("%-15s: %d\n", "大於平均的數", countAboveAverage);
        System.out.printf("%-15s: %d\n", "偶數個數", evenCount);
        System.out.printf("%-15s: %d\n", "奇數個數", oddCount);
        System.out.println("============================");
    }
}

import java.util.Scanner;
import java.util.Arrays;

class LinearSearchDemoin {
    /**
     * 基本線性搜尋：找到第一個符合的元素
     */
    static int linearSearch(int[] array, int target) {
        int comparisons = 0;

        for (int i = 0; i < array.length; i++) {
            comparisons++;
            System.out.printf("第 %d 次比較：array[%d] = %d，目標值 = %d\n",
                    comparisons, i, array[i], target);

            if (array[i] == target) {
                System.out.printf("找到目標值！總共比較了 %d 次\n", comparisons);
                return i;
            }
        }

        System.out.printf("找不到目標值，總共比較了 %d 次\n", comparisons);
        return -1;
    }

    /**
     * 進階線性搜尋：找到所有符合的元素位置
     */
    static int[] linearSearchAll(int[] array, int target) {
        int count = 0;
        for (int value : array) {
            if (value == target) {
                count++;
            }
        }

        if (count == 0) {
            return new int[0];
        }

        int[] result = new int[count];
        int resultIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                result[resultIndex++] = i;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 輸入最多 8 個整數
        System.out.println("請輸入最多 8 個整數，用空白分隔：");
        String[] input = scanner.nextLine().trim().split("\\s+");

        // 限制最多 8 個
        int length = Math.min(input.length, 8);
        int[] numbers = new int[length];
        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        // 輸入搜尋目標
        System.out.print("請輸入要搜尋的目標值：");
        int target = scanner.nextInt();

        System.out.println("\n陣列內容：" + Arrays.toString(numbers));
        System.out.println("搜尋目標：" + target);
        System.out.println();

        // 基本線性搜尋
        System.out.println("=== 基本線性搜尋 ===");
        int result = linearSearch(numbers, target);

        if (result != -1) {
            System.out.printf("在索引位置 %d 找到目標值 %d\n", result, target);
        } else {
            System.out.printf("找不到目標值 %d\n", target);
        }

        // 搜尋所有符合的位置
        System.out.println("\n=== 搜尋所有符合位置 ===");
        int[] allPositions = linearSearchAll(numbers, target);

        if (allPositions.length > 0) {
            System.out.printf("目標值 %d 出現在以下位置：", target);
            for (int i = 0; i < allPositions.length; i++) {
                System.out.print(allPositions[i]);
                if (i < allPositions.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.printf("\n總共出現 %d 次\n", allPositions.length);
        } else {
            System.out.printf("找不到目標值 %d\n", target);
        }

        scanner.close();
    }
}

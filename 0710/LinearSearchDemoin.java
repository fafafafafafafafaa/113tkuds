import java.util.Scanner;
import java.util.Arrays;

public class LinearSearchDemoin {  // 類別名稱需與檔名相同

    /**
     * 基本線性搜尋：從陣列中找出第一個符合目標值的元素索引
     * @param array 要搜尋的整數陣列
     * @param target 要找的目標值
     * @return 找到目標值的索引，找不到回傳 -1
     */
    static int linearSearch(int[] array, int target) {
        int comparisons = 0; // 記錄比較次數
        for (int i = 0; i < array.length; i++) {
            comparisons++;  // 每比較一次就加一
            System.out.printf("第 %d 次比較：array[%d] = %d，目標值 = %d\n",
                    comparisons, i, array[i], target);

            if (array[i] == target) {  // 如果陣列當前元素等於目標值
                System.out.printf("找到目標值！總共比較了 %d 次\n", comparisons);
                return i;  // 回傳索引
            }
        }
        // 若整個陣列都找不到目標值，印出訊息並回傳 -1
        System.out.printf("找不到目標值，總共比較了 %d 次\n", comparisons);
        return -1;
    }

    /**
     * 進階搜尋：找出所有符合目標值的元素索引，並回傳一個陣列
     * @param array 要搜尋的整數陣列
     * @param target 要找的目標值
     * @return 所有符合目標值的索引陣列，若無符合則回傳空陣列
     */
    static int[] linearSearchAll(int[] array, int target) {
        int count = 0;  // 紀錄符合目標值的元素數量
        for (int value : array) {
            if (value == target) {
                count++;  // 計數符合的元素數量
            }
        }

        if (count == 0) {
            return new int[0];  // 沒有符合目標值，回傳空陣列
        }

        // 建立結果陣列來存放所有符合目標值的索引
        int[] result = new int[count];
        int resultIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                result[resultIndex++] = i;  // 將索引存入結果陣列
            }
        }
        return result;  // 回傳結果陣列
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 提示使用者輸入整數陣列，並用空白分隔
        System.out.println("請輸入最多 8 個整數，用空白分隔（例如：12 25 33 22）：");
        String[] input = scanner.nextLine().trim().split("\\s+");

        // 限制陣列長度最多 8 個
        int length = Math.min(input.length, 8);
        int[] numbers = new int[length];
        // 將字串轉換成整數並存入陣列
        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }

        // 提示使用者輸入目標搜尋值
        System.out.print("請輸入要搜尋的目標數字：");
        int target = scanner.nextInt();

        // 印出使用者輸入的陣列與目標值
        System.out.println("\n陣列內容：" + Arrays.toString(numbers));
        System.out.println("搜尋目標：" + target);
        System.out.println();

        // 執行基本線性搜尋
        System.out.println("=== 基本線性搜尋 ===");
        int result = linearSearch(numbers, target);

        if (result != -1) {
            System.out.printf("在索引位置 %d 找到目標值 %d\n", result, target);
        } else {
            System.out.printf("找不到目標值 %d\n", target);
        }

        // 執行搜尋所有符合位置
        System.out.println("\n=== 搜尋所有符合位置 ===");
        int[] allPositions = linearSearchAll(numbers, target);

        if (allPositions.length > 0) {
            System.out.printf("目標值 %d 出現在以下位置：", target);
            // 將所有索引印出，中間用逗號分隔
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

        // 關閉掃描器，避免資源浪費
        scanner.close();
    }
}

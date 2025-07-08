public class ArraySearcher {

    // 方法一：找出目標元素的索引
    public static int findElement(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i; // 找到就回傳索引
            }
        }
        return -1; // 沒找到回傳 -1
    }

    // 方法二：計算目標元素出現的次數
    public static int countOccurrences(int[] array, int target) {
        int count = 0;
        for (int value : array) {
            if (value == target) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // 1. 建立陣列
        int[] data = {12, 45, 23, 67, 34, 89, 56, 78, 91, 25};

        // 5. 測試搜尋數字 67
        int target1 = 67;
        int index1 = findElement(data, target1);
        int count1 = countOccurrences(data, target1);
        System.out.println("搜尋數字：" + target1);
        if (index1 != -1) {
            System.out.println("索引位置：" + index1);
            System.out.println("出現次數：" + count1);
        } else {
            System.out.println("未找到該數字");
        }

        System.out.println(); // 分隔線

        // 5. 測試搜尋數字 100
        int target2 = 100;
        int index2 = findElement(data, target2);
        int count2 = countOccurrences(data, target2);
        System.out.println("搜尋數字：" + target2);
        if (index2 != -1) {
            System.out.println("索引位置：" + index2);
            System.out.println("出現次數：" + count2);
        } else {
            System.out.println("未找到該數字");
        }
    }
}

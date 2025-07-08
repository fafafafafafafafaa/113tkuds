public class ArrayUtility {

    // 列印陣列內容，格式為 [元素1, 元素2, ...]
    public static void printArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    // 原地反轉陣列
    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            left++;
            right--;
        }
    }

    // 建立陣列的副本
    public static int[] copyArray(int[] array) {
        int[] copy = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            copy[i] = array[i];
        }
        return copy;
    }

    // 找出第二大的數值
    public static int findSecondLargest(int[] array) {
        if (array.length < 2) {
            throw new IllegalArgumentException("陣列長度必須至少為2");
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : array) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num < largest) {
                secondLargest = num;
            }
        }

        if (secondLargest == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("找不到第二大的數值");
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 1, 9, 4, 6, 8, 2, 5};

        System.out.print("原陣列內容：");
        printArray(arr);

        // 測試反轉陣列
        reverseArray(arr);
        System.out.print("反轉後陣列：");
        printArray(arr);

        // 測試複製陣列
        int[] arrCopy = copyArray(arr);
        System.out.print("複製的陣列：");
        printArray(arrCopy);

        // 測試找第二大數值
        int secondLargest = findSecondLargest(arr);
        System.out.println("第二大的數值：" + secondLargest);
    }
}

public class ds_04 {
    public static void main(String[] args) {
        // 創建一個包含 5 個整數的陣列
        int[] numbers = {10, 20, 30, 40, 50};

        // 輸出陣列的所有元素
        System.out.println("陣列中的所有元素：");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("元素 " + (i + 1) + ": " + numbers[i]);
        }
    }
}

public class ds_05 {
    public static void main(String[] args) {
        // 創建一個包含 10 個整數的陣列，並初始化元素
        int[] numbers = {5, 8, 12, 20, 15, 3, 9, 7, 10, 4};

        // 計算所有元素的總和
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i]; // 將每個元素加到總和中
        }

        // 輸出總和
        System.out.println("所有元素的總和是：" + sum);
    }
}

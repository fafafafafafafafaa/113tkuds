import java.util.Random;

public class ds_06 {
    public static void main(String[] args) {
        // 創建 Random 物件來生成隨機數
        Random random = new Random();

        // 創建一個包含 10 個隨機整數的陣列
        int[] numbers = new int[10];

        // 將隨機整數填充進陣列
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(100); // 隨機生成 0 到 99 之間的整數
        }

        // 假設第一個元素是最大值
        int max = numbers[0];

        // 遍歷陣列，找出最大值
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        // 輸出陣列中的隨機數字和最大值
        System.out.println("陣列中的隨機整數：");
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println("\n最大值是：" + max);
    }
}

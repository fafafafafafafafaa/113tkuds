public class BasicArrayOperations {
    public static void main(String[] args) {
        // 1. 宣告並建立一個整數陣列，裡面有 10 個數字
        int[] arr = {15, 28, 7, 42, 91, 33, 66, 58, 24, 81};

        // 2. 印出陣列的長度，也就是元素的數量（這裡是10）
        System.out.println("陣列長度: " + arr.length);

        // 3. 把陣列第3個位置（索引是2）的值改成 99
        arr[2] = 99;

        // 4. 把陣列最後一個元素的值改成 100
        arr[arr.length - 1] = 100;

        // 5. 用 for 迴圈一個一個印出陣列裡的所有元素
        //    格式是「索引 i: 對應的值」
        System.out.println("陣列內容：");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("索引 " + i + ": " + arr[i]);
        }
    }
}

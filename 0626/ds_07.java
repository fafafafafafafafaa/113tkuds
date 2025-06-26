public class ds_07 {
    public static void main(String[] args) {
        // 創建並初始化一個 3x3 的二維陣列
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        // 輸出二維陣列的所有元素
        System.out.println("二維陣列的所有元素：");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // 換行
        }
    }
}

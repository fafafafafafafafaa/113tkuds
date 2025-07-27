class LinearSearchDemo {
    /**
     * 基本線性搜尋：找到第一個符合的元素
     * 時間複雜度：最佳 O(1)，最壞 O(n)，平均 O(n/2)
     * 空間複雜度：O(1)
     */
    static int linearSearch(int[] array, int target) {
        int comparisons = 0;  // 紀錄比較次數
        
        for (int i = 0; i < array.length; i++) {
            comparisons++;  // 每比較一次就加一
            System.out.printf("第 %d 次比較：array[%d] = %d，目標值 = %d\n", 
                            comparisons, i, array[i], target);
            
            if (array[i] == target) {  // 如果找到目標值
                System.out.printf("找到目標值！總共比較了 %d 次\n", comparisons);
                return i;  // 回傳該值的索引
            }
        }
        
        // 如果整個陣列都找不到目標值
        System.out.printf("找不到目標值，總共比較了 %d 次\n", comparisons);
        return -1;  // 回傳 -1 表示找不到
    }
    
    /**
     * 進階線性搜尋：找到所有符合的元素位置
     */
    static int[] linearSearchAll(int[] array, int target) {
        int count = 0;  // 計算有幾個值符合
        for (int value : array) {
            if (value == target) {
                count++;
            }
        }
        
        if (count == 0) {  // 沒有找到
            return new int[0];  // 回傳空陣列
        }
        
        // 建立一個陣列用來存放所有符合的索引
        int[] result = new int[count];
        int resultIndex = 0;
        
        // 把符合的索引一個個存進去
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                result[resultIndex++] = i;
            }
        }
        
        return result;  // 回傳所有符合的索引
    }
    
    public static void main(String[] args) {
        int[] numbers = {64, 25, 12, 22, 11, 90, 22, 15};  // 要搜尋的陣列
        int target = 22;  // 要找的數字
        
        System.out.println("陣列內容：" + java.util.Arrays.toString(numbers));
        System.out.println("搜尋目標：" + target);
        System.out.println();
        
        // 基本線性搜尋（找第一個）
        System.out.println("=== 基本線性搜尋 ===");
        int result = linearSearch(numbers, target);
        
        if (result != -1) {
            System.out.printf("在索引位置 %d 找到目標值 %d\n", result, target);
        } else {
            System.out.printf("找不到目標值 %d\n", target);
        }
        
        // 找出所有出現的位置
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
    }
}

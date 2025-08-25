public class Q10_ArrayToStringUtil {

    
    public static String arrayToString(int[] arr) {
        if (arr == null) {
            return "null";
        }
        if (arr.length == 0) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            if (i < arr.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);

        // 讀取陣列長度
        int n = sc.nextInt();
        int[] arr = new int[n];

        // 讀取陣列內容
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 輸出格式化後的陣列字串
        System.out.println(arrayToString(arr));
    }
}

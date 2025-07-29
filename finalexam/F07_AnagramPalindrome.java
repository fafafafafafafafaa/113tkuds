import java.util.*;

public class F07_AnagramPalindrome {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        // 使用大小寫不分，僅統計 a-z 字母出現次數
        int[] freq = new int[26];

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                freq[Character.toLowerCase(ch) - 'a']++;
            }
        }

        // 統計出現奇數次的字母有幾個
        int oddCount = 0;
        for (int f : freq) {
            if (f % 2 != 0) oddCount++;
        }

        if (oddCount <= 1) {
            System.out.println("Possible");
        } else {
            System.out.println("Impossible");
        }

        // -------- 計算複雜度註解 --------
        /*
         * 時間複雜度（Time Complexity）：
         * - 掃描輸入字串長度為 n：O(n)
         * - 統計 26 個字母頻次：O(26)
         * => 總時間複雜度：O(n)

         * 空間複雜度（Space Complexity）：
         * - 使用固定大小陣列 freq[26]：O(1)
         * => 總空間複雜度：O(1)
         */
    }
}

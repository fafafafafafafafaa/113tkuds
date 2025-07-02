import java.util.Scanner;

public class searchnumber {
    public static void main(String[] cargs) {
        int[] s = {1, 3, 5, 7, 9, 11, 13};
        Scanner scanner = new Scanner(System.in);

        System.out.println("請輸入要查找的數字：");
        int x = scanner.nextInt();
        boolean found = false;

        for (int num : s) {
            if (num == x) {
                found = true;
                break;
            }
        }

        if (found) {
            System.out.println("找到了！");
        } else {
            System.out.println("找不到這個數字！");
        }
    }
}

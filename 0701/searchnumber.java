import java.util.Scanner;

public class searchnumber {
    public static void main(String[] args) {
        // 预设要搜寻的数组
        int[] s = {1, 3, 5, 7, 9, 11, 13};
        Scanner scanner = new Scanner(System.in);

        // 直接读取要搜寻的数字
        int x = scanner.nextInt();
        boolean found = false;

        // 线性搜寻
        for (int num : s) {
            if (num == x) {
                found = true;
                break;
            }
        }

        // 输出结果
        if (found) {
            System.out.println("找到了！");
        } else {
            System.out.println("找不到這個數字！");
        }

        scanner.close();
    }
}


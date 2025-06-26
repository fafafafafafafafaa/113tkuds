import java.util.Scanner;

public class ds_02 {
    public static void main(String[] args) {
        // 創建 Scanner 物件以接收使用者輸入
        Scanner scanner = new Scanner(System.in);

        // 提示使用者輸入圓的半徑
        System.out.print("請輸入圓的半徑：");

        // 讀取使用者輸入的半徑
        double radius = scanner.nextDouble();

        // 計算圓的面積，公式為 A = π * r^2
        double area = Math.PI * Math.pow(radius, 2);

        // 輸出計算結果
        System.out.println("圓的面積為：" + area);

        // 關閉 Scanner 物件
        scanner.close();
    }
}

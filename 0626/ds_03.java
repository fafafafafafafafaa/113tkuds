import java.util.Scanner;

public class ds_03 {
    public static void main(String[] args) {
        // 創建 Scanner 物件以接收使用者輸入
        Scanner scanner = new Scanner(System.in);

        // 請使用者輸入姓名
        System.out.print("請輸入您的姓名：");
        String name = scanner.nextLine();

        // 請使用者輸入年齡
        System.out.print("請輸入您的年齡：");
        int age = scanner.nextInt();

        // 清空緩衝區，避免下一次讀取時讀到換行符
        scanner.nextLine();

        // 請使用者輸入城市
        System.out.print("請輸入您所在的城市：");
        String city = scanner.nextLine();

        // 輸出使用者輸入的資訊
        System.out.println("\n您輸入的資訊如下：");
        System.out.println("姓名：" + name);
        System.out.println("年齡：" + age);
        System.out.println("城市：" + city);

        // 關閉 Scanner 物件
        scanner.close();
    }
}

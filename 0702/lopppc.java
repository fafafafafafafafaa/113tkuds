public class lopppc {
    public static void main(String[] args) {
        int x = 0;
        int i = 1;
        int count = 0;

        while (++i <= 100) {
            x = x + 1;
            count++;
        }

        System.out.println("迴圈執行次數：" + count);
        System.out.println("x 的值：" + x);
    }
}

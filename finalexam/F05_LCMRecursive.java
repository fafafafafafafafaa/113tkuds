import java.util.*;

public class F05_LCMRecursive {

    // 輾轉相減法（遞迴）求最大公因數 GCD
    // 複雜度：最壞情況下，每次遞迴呼叫都會將較大數減去較小數1次，導致時間複雜度為 O(max(a,b))。
    // 因為減法只減1次，效率較低。
    public static int gcd(int a, int b) {
        if (a == b) return a;
        if (a > b) return gcd(a - b, b);
        else return gcd(a, b - a);
    }

    // 最小公倍數 LCM
    // 複雜度：主要取決於 gcd 函式的複雜度，因此為 O(max(a,b))
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("LCM: " + lcm(a, b));
    }
}

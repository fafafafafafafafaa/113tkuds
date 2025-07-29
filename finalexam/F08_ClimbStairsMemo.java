import java.util.Scanner;

public class F08_ClimbStairsMemo {
    static long[] memo;

    public static long climbWays(int n) {
        if (n < 0) return 0;
        if (n == 0) return 1;  // 到第0階只有一種方式，就是不動
        if (memo[n] != -1) return memo[n];
        
        memo[n] = climbWays(n - 1) + climbWays(n - 2) + climbWays(n - 3);
        return memo[n];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        memo = new long[n + 1];
        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }

        long ways = climbWays(n);
        System.out.println("Ways: " + ways);
    }
}

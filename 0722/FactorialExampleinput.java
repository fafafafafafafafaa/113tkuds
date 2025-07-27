import java.util.Scanner;

public class FactorialExampleinput {

    public static int factorialWithSteps(int n) {
        int result = 1;
        StringBuilder steps = new StringBuilder();

        if (n == 0) {
            System.out.println("0! = 1");
            return 1;
        }

        for (int i = n; i >= 1; i--) {
            result *= i;
            steps.append(i);
            if (i != 1) {
                steps.append(" * ");
            }
        }

        System.out.println(n + "! = " + steps + " = " + result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("請輸入一個非負整數：");

        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("錯誤：不能輸入負數！");
        } else {
            factorialWithSteps(number);
        }

        scanner.close();
    }
}

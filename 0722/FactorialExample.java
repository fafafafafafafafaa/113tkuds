public class FactorialExample {

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
        factorialWithSteps(3);
        factorialWithSteps(5);
        factorialWithSteps(0);
    }
}

public class matrix_multiplication_trace {
    public static void main(String[] args) {
        // 2x2 矩陣
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] c = new int[2][2];

        // 三層迴圈實作矩陣乘法
        for (int i = 0; i < 2; i++) {          // 控制列
            for (int j = 0; j < 2; j++) {      // 控制欄
                System.out.print("計算位置 c[" + i + "][" + j + "]：");
                int sum = 0;
                StringBuilder step = new StringBuilder();
                StringBuilder products = new StringBuilder();

                for (int k = 0; k < 2; k++) {
                    int mul = a[i][k] * b[k][j];
                    sum += mul;

                    step.append(a[i][k]).append("*").append(b[k][j]);
                    products.append(mul);

                    if (k < 1) {
                        step.append(" + ");
                        products.append(" + ");
                    }
                }

                c[i][j] = sum;
                System.out.println(step + " = " + products + " = " + sum);
            }
        }

        // 印出結果矩陣
        System.out.println("結果矩陣：");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
    }
}

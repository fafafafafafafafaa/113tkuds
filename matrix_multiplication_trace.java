public class matrix_multiplication_trace {public class matrix_multiplication_trace {
    public static void main(String[] args) {
        // 矩陣內容寫死
        int[][] a = {{1, 2}, {3, 4}};
        int[][] b = {{5, 6}, {7, 8}};
        int[][] c = new int[2][2]; // 結果矩陣

        // 三層迴圈進行矩陣乘法
        for (int i = 0; i < 2; i++) {       // 第 i 列
            for (int j = 0; j < 2; j++) {   // 第 j 行
                int sum = 0;
                StringBuilder formula = new StringBuilder();   // 例如：1*5 + 2*7
                StringBuilder product = new StringBuilder();   // 例如：5 + 14

                for (int k = 0; k < 2; k++) {
                    int mul = a[i][k] * b[k][j];
                    sum += mul;

                    // 加入文字說明
                    formula.append(a[i][k]).append("*").append(b[k][j]);
                    product.append(mul);

                    if (k < 1) {
                        formula.append(" + ");
                        product.append(" + ");
                    }
                }

                c[i][j] = sum;

                // 印出計算過程
                System.out.println("計算位置 c[" + i + "][" + j + "]：" + formula + " = " + product + " = " + sum);
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

    
}

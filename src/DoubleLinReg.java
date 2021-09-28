import java.util.Scanner;

public class DoubleLinReg {
    public static void solve(Matrix m, Scanner sc) {
        if (m.ROWS == 0 || m.COLS == 0) {
            System.out.println("No Data Available");
        } else
        if (m.COLS == 1) {
            System.out.println("No Equation Available");
        } else {
            Matrix eq = new Matrix(m.COLS, m.COLS + 1);
            for (int i = 0; i < eq.ROWS; i++) {
                for (int j = 0; j < eq.COLS; j++) {
                    float val = 0;
                    if (i == 0 && j == 0) {
                        val = m.ROWS;
                    } else 
                    if (i == 0) {
                        for (int it = 0; it < m.ROWS; it++) {
                            val += m.e(it, (j % (m.COLS)));
                        }
                    } else 
                    if (j == 0) {
                        for (int it = 0; it < m.ROWS; it++) {
                            val += m.e(it, (i % (m.COLS)));
                        }           
                    } else {
                        for (int it = 0; it < m.ROWS; it++) {
                            val += m.e(it, (i % (m.COLS))) * m.e(it, (j % (m.COLS)));
                        }                   
                    }
                    eq.set(i, j, val);
                }
            }
            Matrix res = new Matrix(eq.COLS-1, 1);
            SPLInverse.solve(eq, res);
            float pred = res.e(0, 0);
            for (int i = 1; i < m.COLS; i++) {
                System.out.print("Masukkan x" + i + ": ");
                float temp = sc.nextFloat();
                pred += temp*res.e(i, 0);
            }
            System.out.println("Prediksi: " + Matrix.format(pred));
        }
    }
}

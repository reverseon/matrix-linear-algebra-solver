import java.util.Scanner;

public class DoubleLinReg {
    public static void solve(Matrix m, Scanner sc) {
        String strOut = "";
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
            strOut = strOut.concat(ReadWriteText.matrixToStr(eq));
            Matrix res = new Matrix(eq.COLS-1, 1);
            SPLInverse.solve(eq, res);
            float pred = res.e(0, 0);
            for (int i = 1; i < m.COLS; i++) {
                System.out.print("Masukkan x" + i + ": ");
                float temp = sc.nextFloat();
                pred += temp*res.e(i, 0);
            }
            System.out.println("Prediksi: " + Matrix.format(pred));
            strOut = strOut.concat("\nSistem persamaan linear yang terbentuk:\n");
            System.out.println("\nSPL yang terbentuk: ");
            String tempStr = " ";
            for(int i = 0; i < eq.ROWS; i++){
                tempStr = "" ;
                for(int j = 0; j < eq.COLS; j++){
                    if(j + 1 != eq.COLS){
                        System.out.print(eq.e(i,j) + "x" + j);
                        tempStr = tempStr.concat(eq.e(i, j) + "x" + j);
                        if (j + 1 < eq.COLS - 1){
                            if (eq.e(i, j + 1) > 0){
                                System.out.print(" + ");
                                tempStr = tempStr.concat(" + ");
                            } else {
                                System.out.print(" ");
                                tempStr = tempStr.concat(" ");
                            }
                        }
                    } else {
                        System.out.print(" = " + eq.e(i, j));
                        tempStr = tempStr.concat(" = " + eq.e(i, j));
                    }
                }
                System.out.println("");
                tempStr = tempStr.concat("\n");
                strOut = strOut.concat(tempStr);
            }
            String iptstr = "";
            do {
                iptstr = sc.nextLine();
                System.out.println("Tulis hasil dalam file .txt? [y/n] : ");
                iptstr = sc.nextLine();
            } while (!iptstr.equals("y") && !iptstr.equals("Y") && !iptstr.equals("n") && !iptstr.equals("N"));
            if (iptstr.equals("y") || iptstr.equals("Y")) {
                ReadWriteText.writetxt(strOut + "\n", sc);
            } else {
                System.out.println("Hasil tidak ditulis");
            }
        }
        
    }
    public static void main (String[] args){
        Matrix m = new Matrix(20, 4);
        Scanner sc = new Scanner(System.in);
        m.readMatrix(sc);
        solve(m, sc);
    }
}

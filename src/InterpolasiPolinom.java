import java.util.Scanner;

public class InterpolasiPolinom {
    public static void intPol(Scanner sc) {
        String iptstr = "", strOut = "Matriks augmented: \n";
        int size = 0;
        int ipt;
        System.out.println("\nMasukkan pilihan input [1] keyboard | [2] file .txt (1/2) : ");
        ipt = sc.nextInt();
        MatrixDouble m = new MatrixDouble(100, 100);
        switch (ipt) {
            case 1:
                System.out.print("Masukkan banyaknya pasangan titik: ");
                size = sc.nextInt();
                m.ROWS = size;
                m.COLS = size + 1;
                System.out.println("\nMasukkan titik (x, y): ");
                for (int i = 0; i < size; i++) {
                    double val = 1;
                    double x = sc.nextDouble();
                    double y = sc.nextDouble();

                    for (int j = 0; j < size; j++) {
                        m.set(i, j, val);
                        val = val * x;
                    }
                    m.set(i, size, y);
                }
                break;
            case 2:
                MatrixDouble tempMatrix = new MatrixDouble(100, 100);
                ReadWriteText.readtxtD(tempMatrix, sc);
                m.ROWS = tempMatrix.ROWS;
                m.COLS = tempMatrix.ROWS + 1;
                for (int i = 0; i < tempMatrix.ROWS; i++) {
                    double dVal = 1;
                    for (int j = 0; j < tempMatrix.ROWS; j++) {   
                        m.set(i, j, dVal);
                        dVal = dVal * tempMatrix.e(i, 0);
                    }
                    m.set(i, tempMatrix.ROWS, tempMatrix.e(i, 1));
                }
                break;
        }
        
        System.out.println("\nMatriks augmented persamaan: ");
        m.displayMatrix();
        strOut = strOut.concat(ReadWriteText.matrixToStrD(m));
        SGJDouble.solve(m);
        m.displayAsEqn();

        double array[] = new double[m.ROWS];
        for (int i = 0; i < m.ROWS; i++) {
            array[i] = m.e(i, m.ROWS);
        }
        System.out.print("\nPersamaan polinom: ");
        strOut = strOut.concat("Persamaan polinom: ");
        for (int i = 0; i < m.ROWS; i++) {

            System.out.printf("%f", array[i]);
            strOut = strOut.concat(Double.toString(array[i]));
            if (i != 0) {
                System.out.printf("x^%d", i);
                strOut = strOut.concat("x^" + Integer.toString(i));
            }
            if (i + 1 != m.ROWS) {
                if (array[i + 1] > 0 && i <m.ROWS) {
                    System.out.print(" + ");
                    strOut = strOut.concat(" + ");
                } else {
                    System.out.print(" ");
                    strOut = strOut.concat(" ");
                }
            }

        }
        strOut = strOut.concat("\n");
        double approx = 0;
        int countX = 0;
        while (approx != -999) {
            System.out.print("\nMasukkan nilai x yang akan diaproksimasi (input -999 untuk keluar): ");
            approx = sc.nextDouble();
            if (approx != -999) {
                countX += 1;
                double result = array[0];
                for (int i = 1; i < m.ROWS; i++) {
                    result = result + (double) (Math.pow(approx, i) * array[i]);
                }
                System.out.printf("Aproksimasi nilai %f terhadap interpolasi polinom: ", approx);
                strOut = strOut.concat("Aproksimasi nilai " + Double.toString(approx) + " terhadap interpolasi polinom: ");
                System.out.println(result);
                strOut = strOut.concat(result + "\n");
            }
        }
        if (countX == 0) {
            System.out.println("Tidak ada nilai x yang dimasukkan\n");
        }
        do {
            iptstr = sc.nextLine();
            System.out.println("Tulis hasil dalam file .txt? [y/n] : ");
            iptstr = sc.nextLine();
        } while (!iptstr.equals("y") && !iptstr.equals("Y") && !iptstr.equals("n") && !iptstr.equals("N"));
        if (iptstr.equals("y") || iptstr.equals("Y")) {
            if (countX == 0) {
                ReadWriteText.writetxt("Tidak ada nilai x yang dimasukkan\n", sc);
            } else {
                ReadWriteText.writetxt(strOut + "\n", sc);
            }
        } else {
            System.out.println("Hasil tidak ditulis");
        }
    }
}

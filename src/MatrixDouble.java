import java.util.Scanner;
import java.text.DecimalFormat;
import java.math.RoundingMode;
public class MatrixDouble {
    double CONTENT[][];
    int ROWS;
    int COLS;
    /* KONSTRUKTOR */
    public MatrixDouble(int row, int col) {
        this.ROWS = row;
        this.COLS = col;
        this.CONTENT = new double[row][col];
    }
    public static String format(double number) {
        DecimalFormat df = new DecimalFormat("#,##0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        String formattedValue = df.format(number);
        formattedValue = formattedValue.replaceAll("^-(?=0(\\.00*)?$)", "");
        return formattedValue;
    }
    public void set(int row, int col, double val) {
        this.CONTENT[row][col] = val;
    }
    public double e(int row, int col) {
        return this.CONTENT[row][col];
    }
    public void readMatrix(Scanner sc) {
        for (int i = 0; i < this.ROWS; i++) {
            for (int j = 0; j < this.COLS; j++) {
                this.CONTENT[i][j] = sc.nextDouble();
            }
        }
    }
    public void displayMatrix() {
        for (int i = 0; i < this.ROWS; i++) {
            for (int j = 0; j < this.COLS; j++) {
                System.out.print((format(e(i,j)))+ " ");
            }
            System.out.println();
        }
    }
    /* OBE */
    /* SWAP BARIS row1 DAN BARIS row2 */
    public void swap(int row1, int row2) {
        double[] temp = this.CONTENT[row1];
        this.CONTENT[row1] = this.CONTENT[row2];
        this.CONTENT[row2] = temp;
    }
    /* KALI BARIS row dengan KONSTANTA K */
    public void kk(int row, double k) {
        for(int j = 0; j < this.COLS; j++) {
            this.CONTENT[row][j] *= k;
        }
    }

    /* TAMBAH BARIS row1 DENGAN (BARIS row2 DIKALI KONSTANTA k) (KALO GAMAU DIKALI KASIH K = 1 AJA) */
    public void tb(int row1, int row2, double k) {
        for (int j = 0; j < this.COLS; j++) {
            this.CONTENT[row1][j] += (e(row2, j) * k);
        }
    }

    public void displayAsEqn() {
        // I.S. REDUCED ECHELON FORM
        int a[] = new int[this.COLS-1];
        for (int i = 0; i < this.COLS - 1; i++) {
            a[i] = 0;
        }
        int ctr = 0;
        for (int i = 0; i < this.ROWS; i++) {
            boolean fRight = true;
            boolean anyprint = false;
            int ldo = -1;
            for (int j = 0; j < this.COLS-1; j++) {
                if (MatrixDouble.format(e(i,j)).equals("1.00")) {
                    ldo = j;
                    anyprint = true;
                    System.out.print("x" + (j + 1) + " = ");
                    break;
                }
            }
            boolean oz = false;
            for (int j = this.COLS-1; j > ldo; j--) {
                if (j == this.COLS-1) {
                    if (format(e(i,j)).equals("0.00")) {
                        oz = true;
                    } else {
                        anyprint = true;
                        oz = false;
                        System.out.print(format(e(i,j)) + " ");
                        fRight = false;
                    }
                } else {
                    if (Double.compare(-1*(e(i,j)), 0) < 0) {
                        String incheck = format(e(i,j));
                        if (incheck.equals("0.00")) {
                            continue;
                        } else
                        if (incheck.equals("1.00")) {
                            anyprint = true;
                            oz = false;
                            System.out.print((fRight ? "" : "- ") + "t");
                            fRight = false;
                            if (a[j] == 0) {
                                ctr++;
                                a[j] = ctr;
                            }
                            System.out.print(a[j] + " ");
                        } else {
                            anyprint = true;
                            oz = false;
                            System.out.print((fRight ? "" : "- ") + incheck + "t");
                            fRight = false;
                            if (a[j] == 0) {
                                ctr++;
                                a[j] = ctr;
                            }
                            System.out.print(a[j] + " ");
                        }
                    } else 
                    if (Double.compare(-1*(e(i,j)), 0) > 0) {
                        String incheck = format(-1*e(i,j));
                        if (incheck.equals("0.00")) {
                            continue;
                        } else
                        if (incheck.equals("1.00")) {
                            anyprint = true;
                            oz = false;
                            System.out.print((fRight ? "" : "+ ") + "t");
                            fRight = false;
                            if (a[j] == 0) {
                                ctr++;
                                a[j] = ctr;
                            }
                            System.out.print(a[j] + " ");
                        } else {
                            anyprint = true;
                            oz = false;
                            System.out.print((fRight ? "" : "+ ") + incheck + "t");
                            fRight = false;
                            if (a[j] == 0) {
                                ctr++;
                                a[j] = ctr;
                            }
                            System.out.print(a[j] + " ");
                        }
                    }
                }
            }
            if (oz == true) {
                System.out.print("0.00");
            }
            if (anyprint) {
                System.out.println();
            }
        }
    }

    public String returnEqn() {
        String eqnStr = "";
        // I.S. REDUCED ECHELON FORM
        int a[] = new int[this.COLS-1];
        for (int i = 0; i < this.COLS - 1; i++) {
            a[i] = 0;
        }
        int ctr = 0;
        for (int i = 0; i < this.ROWS; i++) {
            boolean fRight = true;
            boolean anyprint = false;
            int ldo = -1;
            for (int j = 0; j < this.COLS-1; j++) {
                if (format(e(i,j)).equals("1.00")) {
                    ldo = j;
                    anyprint = true;
                    eqnStr = eqnStr.concat("x" + (j + 1) + " = ");
                    break;
                }
            }
            boolean oz = false;
            for (int j = this.COLS-1; j > ldo; j--) {
                if (j == this.COLS-1) {
                    if (format(e(i,j)).equals("0.00")) {
                        oz = true;
                    } else {
                        anyprint = true;
                        oz = false;
                        eqnStr = eqnStr.concat(format(e(i,j)) + " ");
                        fRight = false;
                    }
                } else {
                    if (Double.compare(-1*(e(i,j)), 0) < 0) {
                        String incheck = format(e(i,j));
                        if (incheck.equals("0.00")) {
                            continue;
                        } else
                        if (incheck.equals("1.00")) {
                            oz = false;
                            anyprint = true;
                            eqnStr = eqnStr.concat((fRight ? "" : "- ") + "t");
                            fRight = false;
                            if (a[j] == 0) {
                                ctr++;
                                a[j] = ctr;
                            }
                            eqnStr = eqnStr.concat(a[j] + " ");
                        } else {
                            anyprint = true;
                            oz = false;
                            eqnStr = eqnStr.concat((fRight ? "" : "- ") + incheck + "t");
                            fRight = false;
                            if (a[j] == 0) {
                                ctr++;
                                a[j] = ctr;
                            }
                            eqnStr = eqnStr.concat(a[j] + " ");
                        }
                    } else 
                    if (Double.compare(-1*(e(i,j)), 0) > 0) {
                        String incheck = format(-1*e(i,j));
                        if (incheck.equals("0.00")) {
                            continue;
                        } else
                        if (incheck.equals("1.00")) {
                            anyprint = true;
                            oz = false;
                            eqnStr = eqnStr.concat((fRight ? "" : "+ ") + "t");
                            fRight = false;
                            if (a[j] == 0) {
                                ctr++;
                                a[j] = ctr;
                            }
                            eqnStr = eqnStr.concat(a[j] + " ");
                        } else {
                            anyprint = true;
                            oz = false;
                            eqnStr = eqnStr.concat((fRight ? "" : "+ ") + incheck + "t");
                            fRight = false;
                            if (a[j] == 0) {
                                ctr++;
                                a[j] = ctr;
                            }
                            eqnStr = eqnStr.concat(a[j] + " ");
                        }
                    }
                }
            }
            if (oz) {
                eqnStr = eqnStr.concat("0 ");
            }
            if (anyprint) {
                eqnStr = eqnStr.concat("\n");
            }
        }
        return eqnStr;
    }
}
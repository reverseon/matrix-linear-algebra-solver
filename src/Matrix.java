import java.util.Scanner;
import java.text.DecimalFormat;

public class Matrix {
    float CONTENT[][];
    int ROWS;
    int COLS;
    /* KONSTRUKTOR */
    public Matrix(int row, int col) {
        this.ROWS = row;
        this.COLS = col;
        this.CONTENT = new float[row][col];
    }
    public void set(int row, int col, float val) {
        this.CONTENT[row][col] = val;
    }
    public float e(int row, int col) {
        return this.CONTENT[row][col];
    }
    public void readMatrix() {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < this.ROWS; i++) {
            for (int j = 0; j < this.COLS; j++) {
                this.CONTENT[i][j] = sc.nextFloat();
            }
        }
        sc.close();
    }
    public void displayMatrix() {
        for (int i = 0; i < this.ROWS; i++) {
            for (int j = 0; j < this.COLS; j++) {
                System.out.print((new DecimalFormat("#.##").format(e(i,j) + 0.0)) + " ");
            }
            System.out.println();
        }
    }
    /* OBE */
    /* SWAP BARIS row1 DAN BARIS row2 */
    public void swap(int row1, int row2) {
        float[] temp = this.CONTENT[row1];
        this.CONTENT[row1] = this.CONTENT[row2];
        this.CONTENT[row2] = temp;
    }
    /* KALI BARIS row dengan KONSTANTA K */
    public void kk(int row, float k) {
        for(int j = 0; j < this.COLS; j++) {
            this.CONTENT[row][j] *= k;
        }
    }

    /* TAMBAH BARIS row1 DENGAN (BARIS row2 DIKALI KONSTANTA k) (KALO GAMAU DIKALI KASIH K = 1 AJA) */
    public void tb(int row1, int row2, float k) {
        for (int j = 0; j < this.COLS; j++) {
            this.CONTENT[row1][j] += (e(row2, j) * k);
        }
    }

    public void displayAsEqn() {
        for (int i = 0; i < this.ROWS; i++) {
            int v = 0;
            for (int j = 0; j < this.COLS; j++) {
                if (j == this.COLS-1 && v > 0) {
                    System.out.print("= " + (new DecimalFormat("#.##").format(e(i,j) + 0.0)));
                } else
                if ((new DecimalFormat("#.##").format(e(i,j) + 0.0)).equals("0")) {
                    continue;
                } else
                if ((new DecimalFormat("#.##").format(e(i,j) + 0.0)).equals("1")) {
                    v++;
                    if (v > 1) {
                        System.out.print("+ ");
                    }
                    System.out.print("x"+(j+1)+" ");
                } else {
                    v++;
                    if (v > 1) {
                        System.out.print("+ ");
                    }
                    System.out.print((new DecimalFormat("#.##").format(e(i,j) + 0.0)) + "x"+j+" ");
                }
            }
            if (v > 0) {
                System.out.println();
            }
            
        }
    }
}
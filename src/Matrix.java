import java.util.Scanner;
import java.text.DecimalFormat;

public class Matrix {
    float CONTENT[][];
    int ROWS;
    int COLS;
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
                System.out.print((new DecimalFormat("#.##").format(e(i,j))) + " ");
            }
            System.out.println();
        }
    }
}
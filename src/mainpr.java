import java.util.Scanner;

public class mainpr {
    public static void main(String[] args) {
        Matrix m1 = new Matrix(2,4);
        m1.readMatrix();
        m1.set(1,3, 12);
        m1.displayMatrix();
    }
}

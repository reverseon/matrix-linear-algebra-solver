import java.util.Scanner;

public class interPolinom {
    public static void main(String[] args){
        int size = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan banyaknya pasangan titik: ");
        size = sc.nextInt();

        Matrix m = new Matrix(size, size + 1);

        System.out.println("Masukkan titik (x, y): ");

        for(int i = 0; i < size; i++){
            float val = 1;
            float x = sc.nextFloat();
            float y = sc.nextFloat();

            for(int j = 0; j < size; j++){
                m.set(i, j, val);
                val = val * x;
            }
            m.set(i, size, y);

        }
        System.out.println("Matriks augmented persamaan: ");
        m.displayMatrix();

        /* nanti di sini masukin SPL */

        sc.close();
    }
}

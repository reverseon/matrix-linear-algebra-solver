import java.util.Scanner;

public class interPolinom {
    public static void main(String[] args){
        int size = 0;

        Scanner sc = new Scanner(System.in);
        System.out.print("Masukkan banyaknya pasangan titik: ");
        size = sc.nextInt();

        Matrix m = new Matrix(size, size + 1);

        System.out.println("\nMasukkan titik (x, y): ");

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
        System.out.println("\nMatriks augmented persamaan: ");
        m.displayMatrix();

        float array[] = SPLCramer.Cramer(m);
        float approx = 0;
        System.out.print("\nMasukkan nilai x yang akan diaproksimasi: ");
        approx = sc.nextFloat();
        float result = array[0];

        for (int i = 1; i < size; i++){
            result = result + approx * array[i];
            approx = approx * approx;
        }

    
        System.out.println(result);
        sc.close();
    }
}

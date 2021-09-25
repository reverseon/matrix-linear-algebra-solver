import java.util.Scanner;

public class InterpolasiPolinom {
    public static void intPol(){
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
        System.out.println("\nDitemukan nilai konstanta menggunakan SPL Cramer: ");

        float array[] = SPLCramer.Cramer(m);
        float approx = 0;

        System.out.print("\nPersamaan polinom: ");
        for(int i = 0; i < size; i++){
            System.out.printf("%f", array[i]);
            if(i != 0){
                System.out.printf("x^%d", i);
            }
            if(i + 1 != size){
                if(array[i + 1] > 0 && i < size){
                    System.out.print(" + ");
                } else {
                    System.out.print(" ");
                }
            }
            
        }



        System.out.print("\nMasukkan nilai x yang akan diaproksimasi: ");
        approx = sc.nextFloat();
        float result = array[0];
        float tempApprox = approx;
        for (int i = 1; i < size; i++){
            result = result + tempApprox * array[i];
            tempApprox = tempApprox * approx;
        }

        System.out.printf("Aproksimasi nilai %f terhadap interpolasi polinom: ", approx);
        System.out.println(result);
        sc.close();
    }
}

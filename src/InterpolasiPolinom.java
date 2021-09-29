import java.util.Scanner;

public class InterpolasiPolinom {
    public static void intPol(Scanner sc){
        int size = 0;

        System.out.print("Masukkan banyaknya pasangan titik: ");
        size = sc.nextInt();

        MatrixDouble m = new MatrixDouble(size, size + 1);

        System.out.println("\nMasukkan titik (x, y): ");

        for(int i = 0; i < size; i++){
            double val = 1;
            double x = sc.nextDouble();
            double y = sc.nextDouble();

            for(int j = 0; j < size; j++){
                m.set(i, j, val);
                val = val * x;
            }
            m.set(i, size, y);

        }
        System.out.println("\nMatriks augmented persamaan: ");
        m.displayMatrix();

        SGJDouble.solve(m);
        m.displayAsEqn();
        
        double array[] = new double[m.ROWS];
        
        for(int i = 0; i < size; i++){
            array[i] = m.e(i, size);
        }

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


        double approx;
        System.out.print("\nMasukkan nilai x yang akan diaproksimasi (input -999 untuk keluar): ");
        approx = sc.nextDouble();

        while (approx != -999){
            double result = array[0];
            for (int i = 1; i < size; i++){
                result = result + (double) (Math.pow(approx, i) * array[i]);
            }
            System.out.printf("Aproksimasi nilai %f terhadap interpolasi polinom: ", approx);
            System.out.println(result);

            System.out.print("\nMasukkan nilai x yang akan diaproksimasi (input -999 untuk keluar): ");
            approx = sc.nextDouble();
        }
   
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        intPol(sc);
    }
}

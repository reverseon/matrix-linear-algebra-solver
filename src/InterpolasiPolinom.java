import java.util.Scanner;

public class InterpolasiPolinom {
    public static void intPol(Scanner sc){
        String iptstr = "", strOut = "";
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
        strOut = strOut.concat("Persamaan polinom: ");
        for(int i = 0; i < size; i++){
            
            System.out.printf("%f", array[i]);
            strOut = strOut.concat(Double.toString(array[i]));
            if(i != 0){
                System.out.printf("x^%d", i);
                strOut = strOut.concat("x^" + Integer.toString(i));
            }
            if(i + 1 != size){
                if(array[i + 1] > 0 && i < size){
                    System.out.print(" + ");
                    strOut = strOut.concat(" + ");
                } else {
                    System.out.print(" ");
                    strOut = strOut.concat(" ");
                }
            }
            
        }

        double approx;
        int countX = 0;
        System.out.print("\nMasukkan nilai x yang akan diaproksimasi (input -999 untuk keluar): ");
        approx = sc.nextDouble();
        while (approx != -999){
            countX += 1;
            double result = array[0];
            for (int i = 1; i < size; i++){
                result = result + (double) (Math.pow(approx, i) * array[i]);
            }
            System.out.printf("Aproksimasi nilai %f terhadap interpolasi polinom: ", approx);
            strOut = strOut.concat("Aproksimasi nilai " + Double.toString(approx) + "terhadap interpolasi polinom: ");
            System.out.println(result);
            strOut = strOut.concat(result + "\n");
            System.out.print("\nMasukkan nilai x yang akan diaproksimasi (input -999 untuk keluar): ");
            approx = sc.nextDouble();
        }
        if (countX == 0) {
            System.out.println("Tidak ada nilai x yang dimasukkan\n");
        }
        do {
            System.out.println("Tulis hasil dalam file .txt? [y/n] : ");
            iptstr = sc.nextLine();
        } while (!iptstr.equals("y") && !iptstr.equals("Y") && !iptstr.equals("n") && !iptstr.equals("N"));
        if (iptstr.equals("y") || iptstr.equals("Y")) {
            if (countX == 0) {
                ReadWriteText.writetxt("Tidak ada nilai x yang dimasukkan\n", sc);
            } else {
                ReadWriteText.writetxt(strOut + "\n", sc);
            }
            ReadWriteText.writetxt(strOut + "\n", sc);
        } else {
            System.out.println("Hasil tidak ditulis");
        }   
    }
}

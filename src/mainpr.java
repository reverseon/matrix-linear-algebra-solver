import java.util.Scanner;

public class mainpr {
    public static void main(String[] args) {
        int input, exitcode;
        exitcode = 0;
        Scanner sc = new Scanner(System.in);

        while (exitcode == 0) {
            mainMenu();
            do {
                input = sc.nextInt();
            } while (input < 1 || input > 6);

            switch (input) {
                case 1:
                    System.out.println("1 Selected.");
                    Matrix m1 = new Matrix(2, 4);
                    m1.readMatrix();
                    m1.set(1, 3, 12);
                    m1.displayMatrix();
                    break;
                case 2:
                    System.out.println("2 Selected.");
                    break;
                case 3:
                    System.out.println("3 Selected.");
                    break;
                case 4:
                    System.out.println("4 Selected.");
                    break;
                case 5:
                    System.out.println("5 Selected.");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    exitcode = 1;
            }
        sc.close();
        }
    }

    public static void mainMenu() {
        System.out.println(
                "MENU \n[1] Sistem Persamaan Linier (currently only used for testing inputs)\n[2] Determinan\n[3] Matriks balikan\n[4] Interpolasi Polinom\n[5] Regresi linier berganda\n[6] Keluar");
        System.out.println("Masukkan pilihan menu (1/2/3/4/5/6) : ");
    }
}

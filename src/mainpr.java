import java.util.Scanner;

public class mainpr {
    public static void main(String[] args) {
        int input, exitcode;
        exitcode = 0;
        Scanner sc = new Scanner(System.in);

        while (exitcode == 0) {
            mainMenu();
            input = -1;
            do {
                input = sc.nextInt();
            } while (input < 0 || input > 6);

            switch (input) {
                case 1:
                    System.out.println("1 Selected.");
                    subMenu1(sc);
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
                    break;
                case 0:
                    debug(sc);
                    break;
            }
        }
        if (exitcode == 1) {
            sc.close();
            System.exit(69);
        }
    }

    public static void mainMenu() {
        System.out.println("MENU \n[1] Sistem Persamaan Linier\n[2] Determinan\n[3] Matriks balikan");
        System.out.println("[4] Interpolasi Polinom\n[5] Regresi linier berganda\n[6] Keluar");
        System.out.println("[0] (Debug) Try Read-Display Matrix");
        System.out.println("Masukkan pilihan menu (1/2/3/4/5/6/0) : ");
    }

    public static void subMenu1(Scanner sc) {
        int input;
        System.out.println("\nSISTEM PERSAMAAN LINIER \n[1] Metode eliminasi Gauss\n[2] Metode eliminasi Gauss-Jordan");
        System.out.println("[3] Metode matriks balikan\n[4] Kaidah Cramer\n[5] Kembali");
        System.out.println("Masukkan pilihan menu (1/2/3/4/5) : ");
        do {
            input = sc.nextInt();
        } while (input < 1 || input > 5);

        switch (input) {
            case 1:
                System.out.println("1 Selected.");
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
        }
    }

    public static void debug(Scanner sc) {
        Matrix m1 = new Matrix(2, 4);
        m1.readMatrix();
        m1.set(1, 3, 12);
        m1.displayMatrix();
        System.out.println("");
    }
}

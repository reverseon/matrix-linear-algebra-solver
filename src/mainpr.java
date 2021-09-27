import java.util.Scanner;

public class mainpr {
    // TODO: Corner cases. Handling more than one action.
    public static void main(String[] args) {
        int input, exitcode;
        Matrix m = new Matrix(5, 5);
        exitcode = 0;
        while (exitcode == 0) {
            mainMenu();
            Scanner sc = new Scanner(System.in);
            input = -1;
            input = input(sc, input, 0, 6);
            switch (input) {
                case 1:
                    System.out.println("1 Selected.");
                    splMenu(sc, m);
                    break;
                case 2:
                    System.out.println("2 Selected.");
                    detMenu(sc, m);
                    break;
                case 3:
                    System.out.println("3 Selected.");
                    matBalik(sc, m);
                    break;
                case 4:
                    System.out.println("4 Selected.");
                    InterpolasiPolinom.intPol();
                    break;
                case 5:
                    System.out.println("5 Selected.");
                    doubleLinReg(sc, m);
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
            System.exit(69);
        }
    }

    public static void mainMenu() {
        System.out.println("MENU \n[1] Sistem Persamaan Linier\n[2] Determinan\n[3] Matriks balikan");
        System.out.println("[4] Interpolasi Polinom\n[5] Regresi linier berganda\n[6] Keluar");
        System.out.println("[0] (Debug) Try Read-Display Matrix");
        System.out.println("Masukkan pilihan menu (1/2/3/4/5/6/0) : ");
    }

    // TODO: Actual implementation of SPLxx.java for each option bcuz idfk how to
    // use it
    public static void splMenu(Scanner sc, Matrix m) {
        int input = 0, ipt1 = 0;
        int result;
        System.out.println("\nSISTEM PERSAMAAN LINIER \n[1] Metode eliminasi Gauss\n[2] Metode eliminasi Gauss-Jordan");
        System.out.println("[3] Metode matriks balikan\n[4] Kaidah Cramer\n[5] Kembali");
        System.out.println("Masukkan pilihan menu (1/2/3/4/5) : ");
        input = input(sc, input, 1, 5);

        switch (input) {
            case 1:
                System.out.println("1 Selected.");
                System.out.println("Masukkan pilihan input [1] keyboard | [2] file .txt (1/2) : ");
                ipt1 = input(sc, ipt1, 1, 2);
                switch (ipt1) {
                    case 1:
                        m.ROWS = sc.nextInt();
                        m.COLS = sc.nextInt();
                        m.readMatrix(sc);
                        break;
                    case 2:
                        ReadWriteText.readtxt(m, sc);
                        break;
                }
                result = SPLGauss.solve(m);
                System.out.println("Hasil perhitungan menggunakan metode eliminasi Gauss: ");
                System.out.println(result);
                break;
            case 2:
                System.out.println("2 Selected.");
                System.out.println("Masukkan pilihan input [1] keyboard | [2] file .txt (1/2) : ");
                ipt1 = input(sc, ipt1, 1, 2);
                switch (ipt1) {
                    case 1:
                        m.ROWS = sc.nextInt();
                        m.COLS = sc.nextInt();
                        m.readMatrix(sc);
                        break;
                    case 2:
                        ReadWriteText.readtxt(m, sc);
                        break;
                }
                result = SPLGaussJordan.solve(m);
                System.out.println("Hasil perhitungan menggunakan metode eliminasi Gauss: ");
                System.out.println(result);
                break;
            case 3:
                System.out.println("3 Selected.");
                System.out.println("Masukkan pilihan input [1] keyboard | [2] file .txt (1/2) : ");
                ipt1 = input(sc, ipt1, 1, 2);
                switch (ipt1) {
                    case 1:
                        m.ROWS = sc.nextInt();
                        m.COLS = sc.nextInt();
                        m.readMatrix(sc);
                        break;
                    case 2:
                        ReadWriteText.readtxt(m, sc);
                        break;
                }
                result = 0;
                System.out.println("Hasil perhitungan menggunakan metode eliminasi Gauss: ");
                System.out.println(result);
                break;
            case 4:
                System.out.println("4 Selected.");
                System.out.println("Masukkan pilihan input [1] keyboard | [2] file .txt (1/2) : ");
                ipt1 = input(sc, ipt1, 1, 2);
                switch (ipt1) {
                    case 1:
                        m.ROWS = sc.nextInt();
                        m.COLS = sc.nextInt();
                        m.readMatrix(sc);
                        break;
                    case 2:
                        ReadWriteText.readtxt(m, sc);
                        break;
                }
                result = 0;
                System.out.println("Hasil perhitungan menggunakan metode eliminasi Gauss: ");
                System.out.println(result);
                break;
            case 5:
                System.out.println("5 Selected.");
                break;
        }
    }

    public static void detMenu(Scanner sc, Matrix m) {
        int input = 0;
        System.out.println("\nDETERMINAN");
        System.out.println("Masukkan pilihan input [1] keyboard | [2] file .txt (1/2) : ");
        input = input(sc, input, 1, 2);
        switch (input) {
            case 1:
                m.ROWS = sc.nextInt();
                m.COLS = m.ROWS;
                m.readMatrix(sc);
                break;
            case 2:
                ReadWriteText.readtxt(m, sc);
                break;
        }
        System.out.println("Determinan dengan ekspansi kofaktor adalah " + Det.determinanKofaktor(m));
        System.out.println("Determinan dengan reduksi baris adalah " + Det.determinanGaussian(m));
    }

    // TODO: Implementasi matBalik() (Matriks Balikan)
    public static void matBalik(Scanner sc, Matrix m) {
        int input = 0;
        System.out.println("\nMATRIKS BALIKAN");
        System.out.println("Masukkan pilihan input [1] keyboard | [2] file .txt (1/2) : ");
        input = input(sc, input, 1, 2);
        switch (input) {
            case 1:
                System.out.print("Jumlah Titik: ");
                m.ROWS = sc.nextInt();
                m.COLS = m.ROWS;
                m.readMatrix(sc);
                break;
            case 2:
                ReadWriteText.readtxt(m, sc);
                break;
        }
    }

    public static void doubleLinReg(Scanner sc, Matrix m) {
        int input = 0;
        System.out.println("\n REGRESI LINIER BERGANDA");
        System.out.println("Masukkan pilihan input [1] keyboard | [2] file .txt (1/2) : ");
        input = input(sc, input, 1, 2);
        switch (input) {
            case 1:
                System.out.print("Jumlah Titik: ");
                m.ROWS = sc.nextInt();
                m.COLS = m.ROWS;
                m.readMatrix(sc);
                break;
            case 2:
                ReadWriteText.readtxt(m, sc);
                break;
        }
        DoubleLinReg.solve(m, sc);
    }

    public static void debug(Scanner sc) {
        Matrix m1 = new Matrix(2, 4);
        m1.readMatrix(sc);
        m1.set(1, 3, 12);
        m1.displayMatrix();
        System.out.println("");
    }

    public static int input(Scanner sc, int ipt, int fOpt, int lOpt) {
        do {
            ipt = sc.nextInt();
        } while (ipt < fOpt || ipt > lOpt);
        return ipt;
    }
}

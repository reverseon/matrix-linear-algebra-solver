import java.util.Scanner;

public class mainpr {
    // TODO: Corner cases. Handling more than one action.
    // TODO: ReadWriteText.writetxt implementations to all options. my head died.
    public static void main(String[] args) {
        int input, exitcode;
        Matrix m = new Matrix(100, 100);
        exitcode = 0;
        while (exitcode == 0) {
            mainMenu();
            Scanner sc = new Scanner(System.in);
            input = -1;
            input = input(sc, input, 1, 7);
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
                    InterpolasiPolinom.intPol(sc);
                    break;
                case 5:
                    System.out.println("5 Selected.");
                    doubleLinReg(sc, m);
                    break;
                case 6:
                    System.out.println("6 Selected.");
                    hilbert(sc, m);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    exitcode = 1;
                    break;
            }
        }
        if (exitcode == 1) {
            System.exit(69);
        }
    }

    public static void mainMenu() {
        System.out.println("\n\n\nMENU \n[1] Sistem Persamaan Linier\n[2] Determinan\n[3] Matriks balikan");
        System.out.println("[4] Interpolasi Polinom\n[5] Regresi linier berganda\n[6] Matriks Hilbert\n[7] Keluar");
        System.out.println("Masukkan pilihan menu (1/2/3/4/5/6/7) : ");
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
                System.out.println("\nMasukkan pilihan input [1] keyboard | [2] file .txt (1/2) : ");
                ipt1 = input(sc, ipt1, 1, 2);
                switch (ipt1) {
                    case 1:
                        int opt;
                        System.out.println("\n[1] Masukan Ax = B\n[2] Matriks Augmented\n");
                        opt = sc.nextInt();
                        switch (opt){ 
                            case 1:
                                System.out.println("1 Selected.");

                                int tempRows, tempCols;
                                System.out.print("Masukkan ukuran baris matriks A: ");
                                tempRows = sc.nextInt();
                                System.out.print("Masukkan ukuran kolom matriks A: ");
                                tempCols = sc.nextInt();
                                
                                Matrix AMatrix = new Matrix(tempRows, tempCols);
                                System.out.println("Masukkan matriks A: ");
                                AMatrix.readMatrix(sc);
                                System.out.print("Masukkan matriks B (ukuran baris x 1) dalam bentuk baris: ");
                                
                                float[] BMatrix = new float[tempRows];
                                for(int i = 0; i < tempRows; i++){
                                    BMatrix[i] = sc.nextFloat();
                                }

                                m.ROWS = tempRows;
                                m.COLS = tempCols + 1;

                                for(int i = 0; i < tempRows; i++){
                                    for (int j = 0; j < tempCols; j++){
                                        m.set(i, j, AMatrix.e(i, j));
                                    }
                                }

                                for(int i = 0; i < tempRows; i++){
                                    m.set(i, tempCols, BMatrix[i]);
                                }

                                break;
                            case 2:
                                System.out.println("2 Selected.");
                                System.out.print("Masukkan ukuran baris matriks: ");
                                m.ROWS = sc.nextInt();
                                System.out.print("Masukkan ukuran kolom matriks: ");
                                m.COLS = sc.nextInt();
                                System.out.println("Masukkan matriks: ");
                                m.readMatrix(sc);
                                break;
                        }
                        break;
                    case 2:
                        ReadWriteText.readtxt(m, sc);
                        break;
                }
                result = SPLGauss.solve(m);
                System.out.println("Hasil perhitungan menggunakan metode eliminasi Gauss: ");
                if (result == 0){
                    m.displayMatrix();
                    System.out.println("Sistem inkonsisten.");
                } else {
                    m.displayAsEqn();
                }
                break;
            case 2:
                System.out.println("2 Selected.");
                System.out.println("Masukkan pilihan input [1] keyboard | [2] file .txt (1/2) : ");
                ipt1 = input(sc, ipt1, 1, 2);
                switch (ipt1) {
                    case 1:
                        int opt;
                        System.out.println("\n[1] Masukan Ax = B\n[2] Matriks Augmented");
                        opt = sc.nextInt();
                        switch (opt){ 
                            case 1:
                                System.out.println("1 Selected.");

                                int tempRows, tempCols;
                                System.out.print("Masukkan ukuran baris matriks A: ");
                                tempRows = sc.nextInt();
                                System.out.print("Masukkan ukuran kolom matriks A: ");
                                tempCols = sc.nextInt();
                                
                                Matrix AMatrix = new Matrix(tempRows, tempCols);
                                System.out.println("Masukkan matriks A: ");
                                AMatrix.readMatrix(sc);
                                System.out.print("Masukkan matriks B (ukuran baris x 1) dalam bentuk baris: ");
                                
                                float[] BMatrix = new float[tempRows];
                                for(int i = 0; i < tempRows; i++){
                                    BMatrix[i] = sc.nextFloat();
                                }

                                m.ROWS = tempRows;
                                m.COLS = tempCols + 1;

                                for(int i = 0; i < tempRows; i++){
                                    for (int j = 0; j < tempCols; j++){
                                        m.set(i, j, AMatrix.e(i, j));
                                    }
                                }

                                for(int i = 0; i < tempRows; i++){
                                    m.set(i, tempCols, BMatrix[i]);
                                }

                                break;
                            case 2:
                                System.out.println("2 Selected.");
                                System.out.print("Masukkan ukuran baris matriks: ");
                                m.ROWS = sc.nextInt();
                                System.out.print("Masukkan ukuran kolom matriks: ");
                                m.COLS = sc.nextInt();
                                System.out.println("Masukkan matriks: ");
                                m.readMatrix(sc);
                                break;
                        }
                        break;
                    case 2:
                        ReadWriteText.readtxt(m, sc);
                        break;
                }
                result = SPLGaussJordan.solve(m);
                System.out.println("Hasil perhitungan menggunakan metode eliminasi Gauss-Jordan: ");
                if (result == 0){
                    System.out.println("Sistem inkonsisten.");
                    m.displayAsEqn();
                } else {
                    m.displayAsEqn();
                }
                break;
            case 3:
                System.out.println("3 Selected.");
                System.out.println("Masukkan pilihan input [1] keyboard | [2] file .txt (1/2) : ");
                ipt1 = input(sc, ipt1, 1, 2);
                switch (ipt1) {
                    case 1:
                        int opt;
                        System.out.println("\n[1] Masukan Ax = B\n[2] Matriks Augmented");
                        opt = sc.nextInt();
                        switch (opt){ 
                            case 1:
                                System.out.println("1 Selected.");

                                int tempRows, tempCols;
                                System.out.print("Masukkan ukuran baris matriks A: ");
                                tempRows = sc.nextInt();
                                System.out.print("Masukkan ukuran kolom matriks A: ");
                                tempCols = sc.nextInt();
                                
                                Matrix AMatrix = new Matrix(tempRows, tempCols);
                                System.out.println("Masukkan matriks A: ");
                                AMatrix.readMatrix(sc);
                                System.out.print("Masukkan matriks B (ukuran baris x 1) dalam bentuk baris: ");
                                
                                float[] BMatrix = new float[tempRows];
                                for(int i = 0; i < tempRows; i++){
                                    BMatrix[i] = sc.nextFloat();
                                }

                                m.ROWS = tempRows;
                                m.COLS = tempCols + 1;

                                for(int i = 0; i < tempRows; i++){
                                    for (int j = 0; j < tempCols; j++){
                                        m.set(i, j, AMatrix.e(i, j));
                                    }
                                }

                                for(int i = 0; i < tempRows; i++){
                                    m.set(i, tempCols, BMatrix[i]);
                                }

                                break;
                            case 2:
                                System.out.println("2 Selected.");
                                System.out.print("Masukkan ukuran baris matriks: ");
                                m.ROWS = sc.nextInt();
                                System.out.print("Masukkan ukuran kolom matriks: ");
                                m.COLS = sc.nextInt();
                                System.out.println("Masukkan matriks: ");
                                m.readMatrix(sc);
                                break;
                        }
                        break;
                    case 2:
                        ReadWriteText.readtxt(m, sc);
                        break;
                }
                result = 0;
                Matrix mOut = new Matrix(m.ROWS, m.COLS);
                SPLInverse.solve(m, mOut);
                System.out.println("Hasil perhitungan menggunakan metode Matriks balikan: ");
                m.displayMatrix();
                break;
            case 4:
                System.out.println("4 Selected.");
                System.out.println("Masukkan pilihan input [1] keyboard | [2] file .txt (1/2) : ");
                ipt1 = input(sc, ipt1, 1, 2);
                switch (ipt1) {
                    case 1:
                        int opt;
                        System.out.println("\n[1] Masukan Ax = B\n[2] Matriks Augmented");
                        opt = sc.nextInt();
                        switch (opt){ 
                            case 1:
                                System.out.println("1 Selected.");

                                int tempRows, tempCols;
                                System.out.print("Masukkan ukuran baris matriks A: ");
                                tempRows = sc.nextInt();
                                System.out.print("Masukkan ukuran kolom matriks A: ");
                                tempCols = sc.nextInt();
                                
                                Matrix AMatrix = new Matrix(tempRows, tempCols);
                                System.out.println("Masukkan matriks A: ");
                                AMatrix.readMatrix(sc);
                                System.out.print("Masukkan matriks B (ukuran baris x 1) dalam bentuk baris: ");
                                
                                float[] BMatrix = new float[tempRows];
                                for(int i = 0; i < tempRows; i++){
                                    BMatrix[i] = sc.nextFloat();
                                }

                                m.ROWS = tempRows;
                                m.COLS = tempCols + 1;

                                for(int i = 0; i < tempRows; i++){
                                    for (int j = 0; j < tempCols; j++){
                                        m.set(i, j, AMatrix.e(i, j));
                                    }
                                }

                                for(int i = 0; i < tempRows; i++){
                                    m.set(i, tempCols, BMatrix[i]);
                                }

                                break;
                            case 2:
                                System.out.println("2 Selected.");
                                System.out.print("Masukkan ukuran baris matriks: ");
                                m.ROWS = sc.nextInt();
                                System.out.print("Masukkan ukuran kolom matriks: ");
                                m.COLS = sc.nextInt();
                                System.out.println("Masukkan matriks: ");
                                m.readMatrix(sc);
                                break;
                        }
                        break;
                    case 2:
                        ReadWriteText.readtxt(m, sc);
                        break;
                }
                result = 0;
                if (m.ROWS == m.COLS - 1){
                    System.out.println("Hasil perhitungan menggunakan kaidah Crammer: ");
                    SPLCramer.Cramer(m);
                } else {
                    System.out.println("Matriks tidak memenuhi persyaratan.");
                }
                System.out.println(result);
                break;
            case 5:
                System.out.println("5 Selected.");
                break;
        }
    }

    public static void detMenu(Scanner sc, Matrix m) {
        int input = 0;
        String iptstr;
        float resKofaktor, resGauss;
        System.out.println("\nDETERMINAN");
        System.out.println("Masukkan pilihan input [1] keyboard | [2] file .txt (1/2) : ");
        input = input(sc, input, 1, 2);
        switch (input) {
            case 1:
                System.out.println("Masukkan banyaknya baris matriks: ");
                m.ROWS = sc.nextInt();
                m.COLS = m.ROWS;
                System.out.println("Kolom matriks disesuaikan dengan baris matriks. Masukkan matriks persegi berukuran baris x baris: ");
                m.readMatrix(sc);
                break;
            case 2:
                ReadWriteText.readtxt(m, sc);
                break;
        }
        resKofaktor = Det.determinanKofaktor(m);
        resGauss = Det.determinanGaussian(m);
        System.out.println("Determinan dengan ekspansi kofaktor adalah " + resKofaktor);
        System.out.println("Determinan dengan reduksi baris adalah " + resGauss);
        do {
            System.out.println("Tulis hasil dalam file .txt? [y/n] : ");
            iptstr = sc.nextLine();
        } while (!iptstr.equals("y") && !iptstr.equals("Y") && !iptstr.equals("n") && !iptstr.equals("N"));
        if (iptstr.equals("y") || iptstr.equals("Y")) {
            ReadWriteText.writetxt("Determinan dengan ekspansi kofaktor adalah " + resKofaktor + "\nDeterminan dengan reduksi baris adalah " + resGauss + "\n", sc);
        } else {
            System.out.println("Hasil tidak ditulis");
        }
    }

    public static void matBalik(Scanner sc, Matrix m) {
        int input = 0, sta = 0;
        String iptstr = "";
        System.out.println("\nMATRIKS BALIKAN");
        System.out.println("Masukkan pilihan input [1] keyboard | [2] file .txt (1/2) : ");
        input = input(sc, input, 1, 2);
        switch (input) {
            case 1:
                System.out.print("Panjang baris dan kolom: ");
                m.ROWS = sc.nextInt();
                m.COLS = m.ROWS;
                System.out.println("Kolom matriks disesuaikan dengan baris matriks. Masukkan matriks persegi berukuran baris x baris: ");
                m.readMatrix(sc);
                break;
            case 2:
                ReadWriteText.readtxt(m, sc);
                break;
        }
        input = 0;
        System.out.println("Masukkan pilihan penyelesaian solusi menggunakan [1] OBE | [2] Kofaktor (1/2) : ");
        input = input(sc, input, 1, 2);
        switch (input) {
            case 1:
                sta = InverseOBE.solve(m);
                if (sta == 0) {
                    System.out.println("Matriks inkonsisten.");
                } else {
                    System.out.println("Matriks balikan menggunakan OBE: ");
                    m.displayMatrix();
                    do {
                        System.out.println("Tulis hasil dalam file .txt? [y/n] : ");
                        iptstr = sc.nextLine();
                        iptstr = sc.nextLine();
                    } while (!iptstr.equals("y") && !iptstr.equals("Y") && !iptstr.equals("n") && !iptstr.equals("N"));
                    if (iptstr.equals("y") || iptstr.equals("Y")) {
                        ReadWriteText.writetxt("Matriks Balikan dari m menggunakan OBE: \n" + ReadWriteText.matrixToStr(m) + "\n", sc);
                    } else {
                        System.out.println("Hasil tidak ditulis");
                    }
                }
                break;
            case 2:
                sta = InverseCofactor.solve(m);
                if (sta == 0) {
                    System.out.println("Matriks inkonsisten.");
                } else {
                    System.out.println("Matriks balikan menggunakan Kofaktor: ");
                    m.displayMatrix();
                    do {
                        System.out.println("Tulis hasil dalam file .txt? [y/n] : ");
                        iptstr = sc.nextLine();
                        iptstr = sc.nextLine();
                    } while (!iptstr.equals("y") && !iptstr.equals("Y") && !iptstr.equals("n") && !iptstr.equals("N"));
                    if (iptstr.equals("y") || iptstr.equals("Y")) {
                        ReadWriteText.writetxt("Matriks Balikan dari m menggunakan Kofaktor: \n" + ReadWriteText.matrixToStr(m) + "\n", sc);
                    } else {
                        System.out.println("Hasil tidak ditulis");
                    }
                }
                break;
        }
    }

    // TODO: doubleLinReg()
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

    public static int input(Scanner sc, int ipt, int fOpt, int lOpt) {
        do {
            ipt = sc.nextInt();
        } while (ipt < fOpt || ipt > lOpt);
        return ipt;
    }

    public static void hilbert(Scanner sc, Matrix m){
        int dimension;
        String iptstr = "", strOut = "";
        System.out.print("Masukkan dimensi matriks: ");
        dimension = sc.nextInt();
        MatrixDouble md = new MatrixDouble(dimension, dimension + 1);
        for(int i = 0; i < dimension; i++){
            for(int j = 0; j < dimension; j++){
                double frac = ((double) 1 / (double)(i + j + 1));

                md.set(i, j, frac);
            }
        }
        for(int i = 0; i < dimension; i++){
            if(i == 0){
                md.set(i, dimension, 1);
            } else {
                md.set(i, dimension, 0);
            }
            
        }
        System.out.println("\nMatriks Hilbert:");
        md.displayMatrix();
        SGJDouble.solve(md);

        double array[] = new double[dimension];

        System.out.println("\nMelalui sistem penyelesaian Gauss-Jordan, diperoleh solusi: ");
        for(int i = 0; i < dimension; i++){
            array[i] = md.e(i, dimension);
        }
        for(int i = 0; i < dimension; i++){
            System.out.print("x" +  i + ": ");
            System.out.println(array[i]);
            strOut = strOut.concat("x" + i + ": " + array[i]);
            if (i != dimension-1) {
                strOut = strOut.concat(", ");
            } else {
                strOut = strOut.concat("\n");
            }
        }
        do {
            System.out.println("Tulis hasil dalam file .txt? [y/n] : ");
            iptstr = sc.nextLine();
        } while (!iptstr.equals("y") && !iptstr.equals("Y") && !iptstr.equals("n") && !iptstr.equals("N"));
        if (iptstr.equals("y") || iptstr.equals("Y")) {
            ReadWriteText.writetxt("Melalui sistem penyelesaian Gauss-Jordan, diperoleh solusi: " + strOut, sc);
        } else {
            System.out.println("Hasil tidak ditulis");
        }
    }
}

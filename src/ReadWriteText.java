import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadWriteText {
    public static void readtxt(Matrix m, Scanner sc) {
        String fileName;
        fileName = sc.nextLine();
        do {
            System.out.println("Masukkan nama file (<namafile>.txt): ");
            fileName = sc.nextLine();
        } while (fileName == "");
        System.out.println("File name selected: " + fileName);
        try {

            File currDir = new File("..");
            File txt = new File(currDir, "test\\" + fileName);
            Scanner sizeReader = new Scanner(txt);
            int rowSize = 0;
            int i = 0, j = 0;
            while (sizeReader.hasNextLine()) {
                rowSize++;
                sizeReader.nextLine();
            }
            sizeReader.close();
            m.ROWS = rowSize;
            Scanner reader = new Scanner(txt);
            try {
                for (i = 0; i < m.ROWS; i++) {
                    String line = reader.nextLine();
                    String[] row = line.split(" ");
                    m.COLS = row.length;
                    for (j = 0; j < m.COLS; j++) {
                        m.set(i, j, Float.parseFloat(row[j]));
                    }
                }
            } finally {
                reader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            // e.printStackTrace();
        }
    }

    public static void readtxtD(MatrixDouble m, Scanner sc) {
        String fileName;
        fileName = sc.nextLine();
        do {
            System.out.println("Masukkan nama file (<namafile>.txt): ");
            fileName = sc.nextLine();
        } while (fileName == "");
        System.out.println("File name selected: " + fileName);
        try {

            File currDir = new File("..");
            File txt = new File(currDir, "test\\" + fileName);
            Scanner sizeReader = new Scanner(txt);
            int rowSize = 0;
            int i = 0, j = 0;
            while (sizeReader.hasNextLine()) {
                rowSize++;
                sizeReader.nextLine();
            }
            sizeReader.close();
            m.ROWS = rowSize;
            Scanner reader = new Scanner(txt);
            try {
                for (i = 0; i < m.ROWS; i++) {
                    String line = reader.nextLine();
                    String[] row = line.split(" ");
                    m.COLS = row.length;
                    for (j = 0; j < m.COLS; j++) {
                        m.set(i, j, Double.parseDouble(row[j]));
                    }
                }
            } finally {
                reader.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            // e.printStackTrace();
        }
    }

    public static void writetxt(String str, Scanner sc) {
        String fileOut;
        do {
            System.out.println("Masukkan nama file output (<namafile>.txt): ");
            fileOut = sc.nextLine();
        } while (fileOut == "");
        try {
            System.out.println("File name selected: " + fileOut);
            File currDir = new File("..");
            File txt = new File(currDir, "test\\" + fileOut);
            FileWriter txtout = new FileWriter(txt, true);
            txtout.write(str);
            txtout.close();
            System.out.println("File writing done.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String matrixToStr(Matrix m) {
        String matStr = "";
        int i, j;
        for (i = 0; i < m.ROWS; i++) {
            for (j = 0; j < m.COLS; j++) {
                matStr = matStr.concat(Float.toString(m.e(i, j)));
                if (j != m.COLS - 1) {
                    matStr = matStr.concat(" ");
                } else {
                    matStr = matStr.concat("\n");
                }
            }
        }
        return matStr;
    }
    public static String matrixToStrD(MatrixDouble m) {
        String matStr = "";
        int i, j;
        for (i = 0; i < m.ROWS; i++) {
            for (j = 0; j < m.COLS; j++) {
                matStr = matStr.concat(Double.toString(m.e(i, j)));
                if (j != m.COLS - 1) {
                    matStr = matStr.concat(" ");
                } else {
                    matStr = matStr.concat("\n");
                }
            }
        }
        return matStr;
    }
}

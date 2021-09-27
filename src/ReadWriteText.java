import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadWriteText {
    public static void readtxt(Matrix m, Scanner sc) {
        String fileName;
        fileName = sc.nextLine();
        System.out.println("Masukkan nama file (<namafile>.txt): ");
        fileName = sc.nextLine();
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
}


public class SPLCramer {
    public static float[] Cramer(Matrix m){
        float array[] = new float[m.ROWS];
        Matrix tempMat = new Matrix(m.ROWS, m.COLS - 1);
        Matrix cutM = new Matrix(m.ROWS, m.COLS - 1);
        for(int k = 0; k < tempMat.ROWS; k++){
            for(int l = 0; l < tempMat.COLS; l++){
                tempMat.set(k, l, m.e(k, l));
                cutM.set(k, l, m.e(k, l));
            }
        }

        for(int i = 0; i < tempMat.ROWS; i++){
            for(int j = 0; j < tempMat.COLS; j++){
                tempMat.set(j, i, m.e(j, m.COLS - 1));
                
            }
            System.out.printf("x%d = ", i + 1);
            System.out.printf("%.2f\n", Det.determinanKofaktor(tempMat) / Det.determinanKofaktor(cutM));
            array[i] = Det.determinanKofaktor(tempMat) / Det.determinanKofaktor(cutM);
            for(int k = 0; k < tempMat.ROWS; k++){
                for(int l = 0; l < tempMat.COLS; l++){
                    tempMat.set(k, l, m.e(k, l));
                }
            }
    
        }
        return array;
    }
    
}

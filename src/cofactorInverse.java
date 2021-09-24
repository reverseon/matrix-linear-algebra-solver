public class cofactorInverse {
    
    public static int solve(Matrix m){
        float det = Det.determinanKofaktor(m);
        int rowCount = 0;
        int colCount = 0;
        Matrix cofactorMatrix = new Matrix(m.ROWS, m.COLS);
        Matrix temp = new Matrix(m.ROWS - 1, m.COLS  - 1);

        if (det == 0){
            return 0;
        } else {
            for(int h = 0; h < m.ROWS ; h++){
                for(int i = 0; i < m.COLS ; i++){
                    rowCount = 0;
                    for(int j = 0; j < m.ROWS ; j++){
                        colCount = 0;
                        for(int k = 0; k < m.COLS; k++){
                            if (j != h && k != i){
                                temp.set(rowCount, colCount, m.e(j, k));
                                colCount = colCount + 1;
                            }
                        }
                        if(j != h){
                            rowCount = rowCount + 1;
                        }
                    }                
                    
                    System.out.println("\n");
                    if ((h % 2 == 0 && i % 2 != 0) || (h % 2 != 0 && i % 2 == 0)){
                        cofactorMatrix.set(h, i, -1 * Det.determinanKofaktor(temp));
                    } else{
                        cofactorMatrix.set(h, i, Det.determinanKofaktor(temp));
                    }
                }
            }
            
            for(int i = 0; i < m.ROWS; i++){
                for(int j = 0; j < m.COLS; j++){
                   m.set(i, j, cofactorMatrix.e(j, i) / det);
                }
            }

            return 1;

        }
    }
}

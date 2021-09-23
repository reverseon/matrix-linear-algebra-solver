public class Det{
    static float determinanKofaktor(Matrix m, int n){
        float det = 0;
        int rowCount = 0;
        int colCount = 0;
        Matrix temp = new Matrix(n - 1, n - 1);
        if (n == 2){
            return (m.e(0, 0) * m.e(1, 1) - m.e(1, 0) * m.e(0, 1)); 
        } else {
            det = 0;
            for(int i = 0; i < n; i++){
                if(m.e(0, 1) != 0){
                    rowCount = 0;
                    for(int j = 0; j < n; j++){
                        colCount = 0;
                        for(int k = 0; k < n; k++){
                            if (k != i){
                                temp.set(rowCount, colCount, m.e(j, k));
                                colCount = colCount + 1;
                            }
                        }
                        if(j != 0){
                            rowCount = rowCount + 1;
                        }
                    }
                    
                    if (i % 2 != 0){
                        det = det - m.e(0, i) * determinanKofaktor(temp, n - 1);
                    }else{
                        det = det + m.e(0, i) * determinanKofaktor(temp, n - 1);
                    }
                    
                }
            }
        }
        return det;
    }
 

    public static void main(String [] args){
        Matrix m = new Matrix(3, 3);
        m.readMatrix();
        m.displayMatrix();
        System.out.println(determinanKofaktor(m, 3));
    }
}




public class Det{
    public static float determinanKofaktor(Matrix m){
        float det = 0;
        int rowCount = 0;
        int colCount = 0;
        Matrix temp = new Matrix(m.ROWS - 1, m.COLS  - 1);
        if (m.ROWS == 2){
            return (m.e(0, 0) * m.e(1, 1) - m.e(1, 0) * m.e(0, 1)); 
        } else if (m.ROWS == 1){
            return m.e(0, 0);
        } else {
            det = 0;
            for(int i = 0; i < m.ROWS ; i++){
                if(m.e(0, i) != 0){
                    rowCount = 0;
                    for(int j = 0; j < m.ROWS ; j++){
                        colCount = 0;
                        for(int k = 0; k < m.ROWS; k++){
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
                        det = det - m.e(0, i) * determinanKofaktor(temp);
                    }else{
                        det = det + m.e(0, i) * determinanKofaktor(temp);
                    }
                    
                }
            }
        }
        return det;
        
    }
 

    public static float determinanGaussian(Matrix m){
        float det = 1;
        int count = 0;
        int limit = 0;
        int swapCount = 0;
        if (m.ROWS == 2){
            return (m.e(0, 0) * m.e(1, 1) - m.e(1, 0) * m.e(0, 1)); 
        } else if (m.ROWS == 1){
            return m.e(0, 0);
        } else {
            swapCount = 0;
            for(int i = 0; i < m.ROWS ; i++){
                if (m.e(i, i) == 0){
                    limit = 1;
                    while ((i + limit) < m.ROWS && m.e(i + limit, i) == 0){
                        limit++;
                    }
                    if (i + limit > i){
                        m.swap(i, i + limit);
                        swapCount++;
                    }
                    
                }
                
                if (det != 0){
                    for(int j = 0; j < m.ROWS ; j++){
                        if(i != j){
                            float comp = m.e(j, i) / m.e(i, i);
                            for(int k = 0; k < m.ROWS ; k++){
                                m.set(j, k, (m.e(j, k) - m.e(i, k) * comp));
                            }
                        }
                    }

                    for(int k = 0; k < m.ROWS; k++){
                        count = 0;
                        for(int l = 0; l < m.ROWS; l++){
                            if(m.e(k, l) == 0){
                                count++;
                            }
                        }
                        if (count == m.ROWS){
                            det = 0;
                        }
        
                    }
                }
                
            }
            if(det != 0){
                for(int i = 0; i < m.ROWS ; i++){
                    det = det * m.e(i, i);
                }
            }

            if (swapCount % 2 != 0){
                det = -det;
            }

            return det;
        }
    } 
}



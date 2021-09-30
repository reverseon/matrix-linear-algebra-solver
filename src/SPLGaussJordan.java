public class SPLGaussJordan {
    public static int solve(Matrix m) {
        float EPSILON = 0.0001f;
        /* RETURN 1 BILA KONSISTEN, RETURN 0 BILA INKONSISTEN. KONDISI MATRIX TELAH TERATLER! */
        int ldo = 0; /* Jumlah Leading One - 1*/
        int rz = 0; /* JUMLAH ROW ZERO DIBAWAH */
        for (int j = 0; j < m.COLS -1; j++) {
            if (ldo > m.ROWS-1) break;
            boolean foundone = false;
            for (int i = ldo; i < m.ROWS; i++) {
                if (Math.abs(1 - m.e(i,j)) < EPSILON) { 
                    m.swap(ldo, i);
                    foundone = true;
                    break;
                }
            }
            if (foundone == false) {
                for (int i = ldo; i < m.ROWS; i++) {
                    if (!(Math.abs(0 - m.e(i,j)) < EPSILON)) { 
                        m.swap(ldo, i);
                        break;
                    }
                }
            }   
            if ((Math.abs(0 - m.e(ldo,j)) < EPSILON)) { 
                continue; // KOLOM ITU NOL SEMUA
            } else {
                float mult = 1/m.e(ldo, j);
                m.kk(ldo, mult);
                for (int i = 0; i < m.ROWS; i++) {
                    if (i != ldo) {
                        float adj = -1*(m.e(i, j));
                        m.tb(i, ldo, adj);
                    }
                }
                /* CARI BARIS NOL SEMUA SETELAH LDO */ 
                for (int i = m.ROWS-1-rz; i >= 0; i--) {
                    if (i != ldo) {
                        boolean hasnonzero = false;
                        for (int jn = 0; jn < m.COLS-1; jn++) {
                            if (!(Math.abs(0 - m.e(i,jn)) < EPSILON)) { 
                                hasnonzero = true;
                                break;
                            }
                        }
                        if (!hasnonzero) {
                            if (!(Math.abs(0 - m.e(i, m.COLS-1)) < EPSILON)) { 
                                return 0; /* INKONSISTEN */
                            }  
                            else {
                                m.swap(i, (m.ROWS-1)-rz);
                                rz++;
                            }
                        }
                    }
                }
                ldo++;
            }
        }
        return 1;
    }
}

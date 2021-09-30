import java.lang.Math;
public class SPLGauss {
    public static int solve(Matrix m) {
        float EPSILON = 0.0001f;
        /* RETURN 1 BILA KONSISTEN, RETURN 0 BILA INKONSISTEN. KONDISI MATRIX TELAH TERATLER! */
        int ldo = 0; /* Jumlah Leading One - 1*/
        int rz = 0; /* JUMLAH ROW ZERO DIBAWAH */
        for (int j = 0; j < m.COLS -1; j++) {
            if (ldo > m.ROWS-1) break;
            boolean foundone = false;
            for (int i = ldo; i < m.ROWS; i++) {
                if ((Math.abs(1 - m.e(i,j)) < EPSILON)) { // (Math.abs(0 - m.e(i,j)) < EPSILON)
                    m.swap(ldo, i);
                    foundone = true;
                    break;
                }
            }
            if (!foundone) {
                for (int i = ldo; i < m.ROWS; i++) {
                    if (!(Math.abs(0 - m.e(i,j)) < EPSILON)) { // (Math.abs(0 - m.e(i,j)) < EPSILON)
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
                for (int i = ldo+1; i < m.ROWS; i++) {
                    float adj = -1*(m.e(i, j));
                    m.tb(i, ldo, adj);
                }
                /* CARI BARIS NOL SEMUA SETELAH LDO */ 
                for (int i = m.ROWS-1-rz; i > ldo; i--) {
                    boolean hasnonzero = false;
                    for (int jn = 0; jn < m.COLS-1; jn++) {
                        if (!(Math.abs(0 - m.e(i,jn)) < EPSILON)) {
                            hasnonzero = true;
                            break;
                        }
                    }
                    if (!hasnonzero) {
                        if (!(Math.abs(0 - m.e(i,m.COLS-1)) < EPSILON)) {
                            return 0;
                        }  
                        else {
                            m.swap(i, (m.ROWS-1)-rz);
                            rz++;
                        }
                    }
                }
                ldo++;
            }
        }
        int ldoidx = -1;
        for (int i = m.ROWS-1; i >= 0; i--) {
            ldoidx = -1;
            for (int j = m.COLS-2; j >= 0; j--) {
                if (Matrix.format(m.e(i,j)).equals("1.00")) {
                    ldoidx = j;
                    break;
                }
            }
            if (ldoidx != -1) {
                for (int ic = 0; ic < m.ROWS; ic++) {
                    if (ic != i) {
                        float mltp = -1*(m.e(ic, ldoidx));
                        m.tb(ic, i, mltp);
                    }
                }
            }
        }
        return 1;
    }
}

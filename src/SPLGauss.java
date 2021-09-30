public class SPLGauss {
    public static int solve(Matrix m) {
        /* RETURN 1 BILA KONSISTEN, RETURN 0 BILA INKONSISTEN. KONDISI MATRIX TELAH TERATLER! */
        int ldo = 0; /* Jumlah Leading One - 1*/
        int rz = 0; /* JUMLAH ROW ZERO DIBAWAH */
        for (int j = 0; j < m.COLS -1; j++) {
            if (ldo > m.ROWS-1) break;
            boolean foundone = false;
            for (int i = ldo; i < m.ROWS; i++) {
                if (Float.compare(1, m.e(i, j)) == 0) {
                    m.swap(ldo, i);
                    foundone = true;
                    break;
                }
            }
            if (!foundone) {
                for (int i = ldo; i < m.ROWS; i++) {
                    if (Float.compare(0, (m.e(i, j) + 0.0f)) != 0) {
                        m.swap(ldo, i);
                        break;
                    }
                }
            }   
            if (Float.compare((m.e(ldo, j) + 0.0f), 0) == 0) {
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
                        if (Float.compare(0, m.e(i,jn)) != 0) {
                            hasnonzero = true;
                            break;
                        }
                    }
                    if (!hasnonzero) {
                        if (Float.compare(0, (m.e(i, m.COLS-1) +0.0f)) != 0) {
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

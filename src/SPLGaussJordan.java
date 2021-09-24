public class SPLGaussJordan {
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
                for (int i = 0; i < m.ROWS; i++) {
                    if (i != ldo) {
                        float adj = -1*(m.e(i, j));
                        m.tb(i, ldo, adj);
                    }
                }
                /* CARI BARIS NOL SEMUA SETELAH LDO */ 
                for (int i = m.ROWS-1-rz; i >= 0; i--) {
                    if (i != ldo) {
                        float res = 0;
                        for (int jn = 0; jn < m.COLS-1; jn++) {
                            res += m.e(i, jn);
                        }
                        if (Float.compare(0, (res + 0.0f)) == 0) {
                            if (Float.compare(0, (m.e(i, m.COLS-1) +0.0f)) != 0) {
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

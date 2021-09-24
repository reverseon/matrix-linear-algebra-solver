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
                    float res = 0;
                    for (int jn = 0; jn < m.COLS-1; jn++) {
                        res += m.e(i, jn);
                    }
                    if (Float.compare(0, (res + 0.0f)) == 0) {
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
        for (int i = m.ROWS-1; i >= 0; i--) {
            boolean[] w = new boolean[m.COLS-1];
            for (int j = 0; j < m.COLS-1; j++) {
                if (Float.compare((m.e(i,j) + 0.0f), 0) == 0) {
                    w[j] = false;
                } else {
                    w[j] = true;
                }
            }
            for (int ic = 0; ic < m.ROWS; ic++) {
                if (ic != i) {
                    for (int jc = 0; jc < m.COLS-1; jc++) {
                        if (w[jc] && Float.compare((m.e(ic, jc) + 0.0f), 0) != 0) {
                            float mltp = -1*(m.e(ic, jc) / m.e(i, jc));
                            m.tb(ic, i, mltp);
                            break; // CUKUP SATU AJA
                        }
                    }
                }
            }
        }
        return 1;
    }
}

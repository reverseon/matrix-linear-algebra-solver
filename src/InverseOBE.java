public class InverseOBE {
    public static int solve(Matrix m) {
        int status = 0;
        float md = Det.determinanKofaktor(m);
        if (m.COLS != m.ROWS) {
            return 0;
        } else 
        if (Float.compare((md + 0.0f), 0) == 0) {
            return 0;
        } else {
            Matrix sm = new Matrix(m.ROWS, m.COLS*2);
            for (int i = 0; i < m.ROWS; i++) {
                for (int j = 0; j < m.COLS; j++) {
                    sm.set(i, j, m.e(i,j));
                }
                for (int j = m.COLS; j < sm.COLS; j++) {
                    sm.set(i, j, 0);
                }
                sm.set(i, m.COLS+i, 1);
            }
            // TO OBE
            int ldo = 0; /* Jumlah Leading One - 1*/
            int rz = 0; /* JUMLAH ROW ZERO DIBAWAH */
            for (int j = 0; j < m.COLS; j++) {
                if (ldo > m.ROWS-1) break;
                boolean foundone = false;
                for (int i = ldo; i < m.ROWS; i++) {
                    if (Float.compare(1, sm.e(i, j)) == 0) {
                        sm.swap(ldo, i);
                        foundone = true;
                        break;
                    }
                }
                if (!foundone) {
                    for (int i = ldo; i < m.ROWS; i++) {
                        if (Float.compare(0, (sm.e(i, j) + 0.0f)) != 0) {
                            sm.swap(ldo, i);
                            break;
                        }
                    }
                }   
                if (Float.compare((sm.e(ldo, j) + 0.0f), 0) == 0) {
                    continue; // KOLOM ITU NOL SEMUA
                } else {
                    float mult = 1/sm.e(ldo, j);
                    sm.kk(ldo, mult);
                    for (int i = 0; i < m.ROWS; i++) {
                        if (i != ldo) {
                            float adj = -1*(sm.e(i, j));
                            sm.tb(i, ldo, adj);
                        }
                    }
                    /* CARI BARIS NOL SEMUA SETELAH LDO */ 
                    for (int i = m.ROWS-1-rz; i >= 0; i--) {
                        if (i != ldo) {
                            float res = 0;
                            for (int jn = 0; jn < m.COLS; jn++) {
                                res += sm.e(i, jn);
                            }
                            if (Float.compare(0, (res + 0.0f)) == 0) {
                                sm.swap(i, (sm.ROWS-1)-rz);
                                rz++;
                            }
                        }
                    }
                    ldo++;
                }
            }
            for (int i = 0; i < m.ROWS; i++) {
                for (int j = 0; j < m.COLS; j++) {
                    m.set(i, j, sm.e(i,m.COLS+j)); 
                }
            }
            status = 1;
        }
        return status;
    }
}

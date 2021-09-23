public class SPLGauss {
    public static void solve(Matrix m) {
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
                    if (Float.compare(0, m.e(i, j)) != 0) {
                        m.swap(ldo, i);
                        break;
                    }
                }
            }   
            if (Float.compare(m.e(ldo, j), 0) == 0) {
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
                    if (Float.compare(0, res) == 0) {
                        if (Float.compare(0, m.e(i, m.COLS-1)) != 0) {
                            System.out.println("Sistem Inkonsisten");
                            return;
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
        m.displayAsEqn();
    }
}

public class SPLInverse {
    /* USE WITH CAUTION, NO CHECKING AVAILABLE IN TRANSITIVE FUNCTION */
    public static void copyMatrix(Matrix in, Matrix out) {
        for (int i = 0; i < out.ROWS; i++) {
            for (int j = 0; j < out.COLS; j++) {
                out.set(i,j, in.e(i, j));
            }
        }
    }
    public static Matrix multi(Matrix a, Matrix b) {
        Matrix out = new Matrix(a.ROWS, b.COLS);
        for (int i = 0; i < out.ROWS; i++) {
            for (int j = 0; j < out.COLS; j++) {
                out.set(i, j, 0);
                for (int k = 0; k < a.COLS; k++) {
                    out.set(i, j, (out.e(i, j) + (a.e(i, k)*b.e(k,j))));
                }
            }
        }
        return out;
    }
    public static int solve(Matrix m, Matrix res) {
        Matrix im = new Matrix(m.ROWS, m.COLS-1);
        Matrix eq = new Matrix(m.ROWS, 1);
        for (int i = 0; i < m.ROWS; i++) {
            for (int j = 0; j < m.COLS-1;j++) {
                im.set(i, j, m.e(i, j));
            }
            eq.set(i, 0, m.e(i, m.COLS-1));
        }
        int statinv = InverseOBE.solve(im);
        if (statinv == 0) {
            return 0;
        } else {
            copyMatrix(multi(im, eq), res);
            return 1;
        }
    }
}

public String returnEqn() {
        String eqnStr = "";
        // I.S. REDUCED ECHELON FORM
        int a[] = new int[this.COLS-1];
        for (int i = 0; i < this.COLS - 1; i++) {
            a[i] = 0;
        }
        int ctr = 0;
        for (int i = 0; i < this.ROWS; i++) {
            boolean fRight = true;
            boolean anyprint = false;
            int ldo = -1;
            for (int j = 0; j < this.COLS-1; j++) {
                if (format(e(i,j)).equals("1.00")) {
                    ldo = j;
                    anyprint = true;
                    eqnStr = eqnStr.concat("x" + (j + 1) + " = ");
                    break;
                }
            }
            boolean oz = false;
            for (int j = this.COLS-1; j > ldo; j--) {
                if (j == this.COLS-1) {
                    if (format(e(i,j)).equals("0.00")) {
                        oz = true;
                    } else {
                        anyprint = true;
                        oz = false;
                        eqnStr = eqnStr.concat(format(e(i,j)) + " ");
                        fRight = false;
                    }
                } else {
                    if (Float.compare(-1*(e(i,j)), 0) < 0) {
                        String incheck = format(e(i,j));
                        if (incheck.equals("0.00")) {
                            continue;
                        } else
                        if (incheck.equals("1.00")) {
                            oz = false;
                            anyprint = true;
                            eqnStr = eqnStr.concat((fRight ? "" : "- ") + "t");
                            fRight = false;
                            if (a[j] == 0) {
                                ctr++;
                                a[j] = ctr;
                            }
                            eqnStr = eqnStr.concat(a[j] + " ");
                        } else {
                            anyprint = true;
                            oz = false;
                            eqnStr = eqnStr.concat((fRight ? "" : "- ") + incheck + "t");
                            fRight = false;
                            if (a[j] == 0) {
                                ctr++;
                                a[j] = ctr;
                            }
                            eqnStr = eqnStr.concat(a[j] + " ");
                        }
                    } else 
                    if (Float.compare(-1*(e(i,j)), 0) > 0) {
                        String incheck = format(-1*e(i,j));
                        if (incheck.equals("0.00")) {
                            continue;
                        } else
                        if (incheck.equals("1.00")) {
                            anyprint = true;
                            oz = false;
                            eqnStr = eqnStr.concat((fRight ? "" : "+ ") + "t");
                            fRight = false;
                            if (a[j] == 0) {
                                ctr++;
                                a[j] = ctr;
                            }
                            eqnStr = eqnStr.concat(a[j] + " ");
                        } else {
                            anyprint = true;
                            oz = false;
                            eqnStr = eqnStr.concat((fRight ? "" : "+ ") + incheck + "t");
                            fRight = false;
                            if (a[j] == 0) {
                                ctr++;
                                a[j] = ctr;
                            }
                            eqnStr = eqnStr.concat(a[j] + " ");
                        }
                    }
                }
            }
            if (oz) {
                eqnStr = eqnStr.concat("0 ");
            }
            if (anyprint) {
                eqnStr = eqnStr.concat("\n");
            }
        }
        return eqnStr;
    }

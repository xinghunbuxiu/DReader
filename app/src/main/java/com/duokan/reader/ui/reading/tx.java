package com.duokan.reader.ui.reading;

public class tx {
    private int a;

    public tx() {
        this.a = 129;
        this.a = 129;
    }

    public boolean a(int i, int i2) {
        int i3 = this.a;
        b(i);
        c(i2);
        return this.a != i3;
    }

    public boolean a(int i) {
        return (this.a & i) == i;
    }

    public int a() {
        return this.a;
    }

    private void b(int i) {
        if (i != 0) {
            this.a |= i;
            if ((i & 1) == 1) {
                this.a &= -5;
                this.a &= -33;
                this.a &= -9;
            }
            if ((i & 2) == 2) {
                this.a &= -2;
            }
            if ((i & 4) == 4) {
                this.a &= -2;
                this.a &= -17;
                this.a &= -9;
                this.a &= -65;
            }
            if ((i & 8) == 8) {
                this.a &= -2;
                this.a &= -5;
                this.a &= -17;
                this.a &= -65;
            }
            if ((i & 16) == 16) {
                this.a &= -5;
                this.a &= -9;
            }
            if ((i & 64) == 64) {
                this.a &= -5;
                this.a &= -9;
            }
        }
    }

    private void c(int i) {
        if (i != 0) {
            this.a &= i ^ -1;
            if (!a(4) && !a(8) && !a(2)) {
                b(1);
            }
        }
    }
}

package com.duokan.reader.ui.reading;

public class uk {
    /* renamed from: a */
    private int f11012a;

    public uk() {
        this.f11012a = 129;
        this.f11012a = 129;
    }

    /* renamed from: a */
    public boolean m15023a(int i, int i2) {
        int i3 = this.f11012a;
        m15019b(i);
        m15020c(i2);
        return this.f11012a != i3;
    }

    /* renamed from: a */
    public boolean m15022a(int i) {
        return (this.f11012a & i) == i;
    }

    /* renamed from: a */
    public int m15021a() {
        return this.f11012a;
    }

    /* renamed from: b */
    private void m15019b(int i) {
        if (i != 0) {
            this.f11012a |= i;
            if ((i & 1) == 1) {
                this.f11012a &= -5;
                this.f11012a &= -33;
                this.f11012a &= -9;
            }
            if ((i & 2) == 2) {
                this.f11012a &= -2;
            }
            if ((i & 4) == 4) {
                this.f11012a &= -2;
                this.f11012a &= -17;
                this.f11012a &= -9;
                this.f11012a &= -65;
            }
            if ((i & 8) == 8) {
                this.f11012a &= -2;
                this.f11012a &= -5;
                this.f11012a &= -17;
                this.f11012a &= -65;
            }
            if ((i & 16) == 16) {
                this.f11012a &= -5;
                this.f11012a &= -9;
            }
            if ((i & 64) == 64) {
                this.f11012a &= -5;
                this.f11012a &= -9;
            }
        }
    }

    /* renamed from: c */
    private void m15020c(int i) {
        if (i != 0) {
            this.f11012a &= i ^ -1;
            if (!m15022a(4) && !m15022a(8) && !m15022a(2)) {
                m15019b(1);
            }
        }
    }
}

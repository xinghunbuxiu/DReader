package com.duokan.core.ui;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Transformation;

class bc {
    /* renamed from: a */
    private int f993a = -1;
    /* renamed from: b */
    private bd f994b = null;
    /* renamed from: c */
    private View f995c = null;
    /* renamed from: d */
    private int f996d = MeasureSpec.makeMeasureSpec(0, 0);
    /* renamed from: e */
    private int f997e = MeasureSpec.makeMeasureSpec(0, 0);
    /* renamed from: f */
    private int f998f = -1;
    /* renamed from: g */
    private int f999g = -1;
    /* renamed from: h */
    private int f1000h = 0;
    /* renamed from: i */
    private int f1001i = 0;
    /* renamed from: j */
    private int f1002j = -1;
    /* renamed from: k */
    private int f1003k = -1;
    /* renamed from: l */
    private int f1004l = 1;
    /* renamed from: m */
    private float f1005m = 1.0f;
    /* renamed from: n */
    private int f1006n = 0;
    /* renamed from: o */
    private int f1007o = 0;
    /* renamed from: p */
    private Transformation f1008p = null;

    public bc(int i) {
        this.f993a = i;
    }

    /* renamed from: a */
    public boolean m1664a() {
        return (this.f1004l & 1) == 1;
    }

    /* renamed from: a */
    public void m1663a(boolean z) {
        this.f1004l = z ? this.f1004l | 1 : this.f1004l & -2;
    }

    /* renamed from: b */
    public boolean m1666b() {
        return (this.f1004l & 2) == 2;
    }

    /* renamed from: b */
    public void m1665b(boolean z) {
        this.f1004l = z ? this.f1004l | 2 : this.f1004l & -3;
    }

    /* renamed from: c */
    public boolean m1668c() {
        return (this.f1004l & 4) == 4;
    }

    /* renamed from: c */
    public void m1667c(boolean z) {
        this.f1004l = z ? this.f1004l | 4 : this.f1004l & -5;
    }

    /* renamed from: d */
    public boolean m1670d() {
        return (this.f1004l & 8) == 8;
    }

    /* renamed from: d */
    public void m1669d(boolean z) {
        this.f1004l = z ? this.f1004l | 8 : this.f1004l & -9;
    }

    /* renamed from: e */
    public boolean m1672e() {
        return (this.f1004l & 16) == 16;
    }

    /* renamed from: e */
    public void m1671e(boolean z) {
        this.f1004l = z ? this.f1004l | 16 : this.f1004l & -17;
    }

    /* renamed from: f */
    public boolean m1674f() {
        return (this.f1004l & 32) == 32;
    }

    /* renamed from: f */
    public void m1673f(boolean z) {
        this.f1004l = z ? this.f1004l | 32 : this.f1004l & -33;
    }

    /* renamed from: a */
    public void m1662a(int i, int i2) {
        if (this.f1006n != i || this.f1007o != i2) {
            this.f1006n = i;
            this.f1007o = i2;
            if (this.f1006n != 0 || this.f1007o != 0) {
                if (this.f1008p == null) {
                    this.f1008p = new Transformation();
                }
                this.f1008p.getMatrix().reset();
                this.f1008p.getMatrix().preTranslate((float) this.f1006n, (float) this.f1007o);
                this.f1008p.setTransformationType(this.f1008p.getTransformationType() | 2);
            } else if (this.f1008p != null) {
                if (Float.compare(this.f1008p.getAlpha(), 1.0f) == 0) {
                    this.f1008p = null;
                } else {
                    this.f1008p.getMatrix().reset();
                    this.f1008p.setTransformationType(1);
                }
            }
            if (this.f994b != null) {
                this.f994b.invalidate();
            }
        }
    }

    /* renamed from: a */
    public void m1661a(float f) {
        if (Float.compare(this.f1005m, f) != 0) {
            this.f1005m = f;
            if (Float.compare(this.f1005m, 1.0f) != 0) {
                if (this.f1008p == null) {
                    this.f1008p = new Transformation();
                }
                this.f1008p.setAlpha(this.f1005m);
                this.f1008p.setTransformationType(this.f1008p.getTransformationType() | 1);
            } else if (this.f1008p != null) {
                if (this.f1008p.getMatrix().isIdentity()) {
                    this.f1008p = null;
                } else {
                    this.f1008p.setAlpha(this.f1005m);
                    this.f1008p.setTransformationType(2);
                }
            }
            if (this.f994b != null) {
                this.f994b.invalidate();
            }
        }
    }
}

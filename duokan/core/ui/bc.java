package com.duokan.core.ui;

import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Transformation;

class bc {
    private int a = -1;
    private bd b = null;
    private View c = null;
    private int d = MeasureSpec.makeMeasureSpec(0, 0);
    private int e = MeasureSpec.makeMeasureSpec(0, 0);
    private int f = -1;
    private int g = -1;
    private int h = 0;
    private int i = 0;
    private int j = -1;
    private int k = -1;
    private int l = 1;
    private float m = 1.0f;
    private int n = 0;
    private int o = 0;
    private Transformation p = null;

    public bc(int i) {
        this.a = i;
    }

    public boolean a() {
        return (this.l & 1) == 1;
    }

    public void a(boolean z) {
        this.l = z ? this.l | 1 : this.l & -2;
    }

    public boolean b() {
        return (this.l & 2) == 2;
    }

    public void b(boolean z) {
        this.l = z ? this.l | 2 : this.l & -3;
    }

    public boolean c() {
        return (this.l & 4) == 4;
    }

    public void c(boolean z) {
        this.l = z ? this.l | 4 : this.l & -5;
    }

    public boolean d() {
        return (this.l & 8) == 8;
    }

    public void d(boolean z) {
        this.l = z ? this.l | 8 : this.l & -9;
    }

    public boolean e() {
        return (this.l & 16) == 16;
    }

    public void e(boolean z) {
        this.l = z ? this.l | 16 : this.l & -17;
    }

    public boolean f() {
        return (this.l & 32) == 32;
    }

    public void f(boolean z) {
        this.l = z ? this.l | 32 : this.l & -33;
    }

    public void a(int i, int i2) {
        if (this.n != i || this.o != i2) {
            this.n = i;
            this.o = i2;
            if (this.n != 0 || this.o != 0) {
                if (this.p == null) {
                    this.p = new Transformation();
                }
                this.p.getMatrix().reset();
                this.p.getMatrix().preTranslate((float) this.n, (float) this.o);
                this.p.setTransformationType(this.p.getTransformationType() | 2);
            } else if (this.p != null) {
                if (Float.compare(this.p.getAlpha(), 1.0f) == 0) {
                    this.p = null;
                } else {
                    this.p.getMatrix().reset();
                    this.p.setTransformationType(1);
                }
            }
            if (this.b != null) {
                this.b.invalidate();
            }
        }
    }

    public void a(float f) {
        if (Float.compare(this.m, f) != 0) {
            this.m = f;
            if (Float.compare(this.m, 1.0f) != 0) {
                if (this.p == null) {
                    this.p = new Transformation();
                }
                this.p.setAlpha(this.m);
                this.p.setTransformationType(this.p.getTransformationType() | 1);
            } else if (this.p != null) {
                if (this.p.getMatrix().isIdentity()) {
                    this.p = null;
                } else {
                    this.p.setAlpha(this.m);
                    this.p.setTransformationType(2);
                }
            }
            if (this.b != null) {
                this.b.invalidate();
            }
        }
    }
}

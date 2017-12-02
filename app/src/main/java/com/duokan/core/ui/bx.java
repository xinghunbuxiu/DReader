package com.duokan.core.ui;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class bx {
    private int a;
    private final by b;
    private final by c;
    private Interpolator d;
    private final boolean e;

    public bx(Context context) {
        this(context, null);
    }

    public bx(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public bx(Context context, Interpolator interpolator, boolean z) {
        this.d = interpolator;
        this.e = z;
        this.b = new by();
        this.c = new by();
        by.a(context);
    }

    void a(Interpolator interpolator) {
        this.d = interpolator;
    }

    public final boolean a() {
        return this.b.k && this.c.k;
    }

    public final void a(boolean z) {
        this.b.k = this.c.k = z;
    }

    public final int b() {
        return this.b.b;
    }

    public final int c() {
        return this.c.b;
    }

    public float d() {
        return this.b.e;
    }

    public float e() {
        return this.c.e;
    }

    public final int f() {
        return this.b.c;
    }

    public final int g() {
        return this.c.c;
    }

    public boolean h() {
        if (a()) {
            return false;
        }
        switch (this.a) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.b.g;
                int e = this.b.h;
                if (currentAnimationTimeMillis >= ((long) e)) {
                    i();
                    break;
                }
                float f = ((float) currentAnimationTimeMillis) / ((float) e);
                if (this.d == null) {
                    f = ci.a(f);
                } else {
                    f = this.d.getInterpolation(f);
                }
                this.b.a(f);
                this.c.a(f);
                break;
            case 1:
                if (!(this.b.k || this.b.c() || this.b.b())) {
                    this.b.a();
                }
                if (!(this.c.k || this.c.c() || this.c.b())) {
                    this.c.a();
                    break;
                }
        }
        return true;
    }

    public void a(int i, int i2, int i3, int i4, int i5) {
        this.a = 0;
        this.b.a(i, i3, i5);
        this.c.a(i2, i4, i5);
    }

    public boolean a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.a = 1;
        boolean b = this.b.b(i, i3, i4);
        boolean b2 = this.c.b(i2, i5, i6);
        if (b || b2) {
            return true;
        }
        return false;
    }

    public void a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.e && !a()) {
            float c = this.b.e;
            float c2 = this.c.e;
            if (Math.signum((float) i3) == Math.signum(c) && Math.signum((float) i4) == Math.signum(c2)) {
                i4 = (int) (((float) i4) + c2);
                i11 = (int) (c + ((float) i3));
                this.a = 1;
                this.b.a(i, i11, i5, i6, i9);
                this.c.a(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.a = 1;
        this.b.a(i, i11, i5, i6, i9);
        this.c.a(i2, i4, i7, i8, i10);
    }

    public void b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.a = 1;
        this.b.c(i, i3, i5);
        this.c.c(i2, i4, i6);
    }

    public void i() {
        this.b.a();
        this.c.a();
    }
}

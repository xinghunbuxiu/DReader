package com.duokan.core.ui;

import android.content.Context;
import android.util.Log;
import android.view.animation.AnimationUtils;

import org.apache.http.HttpStatus;

class by {
    private static float o;
    private static float p = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    private static final float[] q = new float[HttpStatus.SC_MOVED_PERMANENTLY];
    private static final float[] r = new float[HttpStatus.SC_MOVED_PERMANENTLY];
    private int a;
    private int b;
    private int c;
    private int d;
    private float e;
    private float f;
    private long g;
    private int h;
    private int i;
    private int j;
    private boolean k = true;
    private int l;
    private float m = 0.005f;
    private int n = 0;

    static {
        float f = 0.0f;
        int i = 0;
        float f2 = 0.0f;
        while (i < HttpStatus.SC_MULTIPLE_CHOICES) {
            float f3;
            float f4 = ((float) i) / 300.0f;
            float f5 = 1.0f;
            float f6 = f2;
            while (true) {
                f2 = ((f5 - f6) / 2.0f) + f6;
                f3 = (3.0f * f2) * (1.0f - f2);
                float f7 = ((((1.0f - f2) * 0.175f) + (0.35000002f * f2)) * f3) + ((f2 * f2) * f2);
                if (((double) Math.abs(f7 - f4)) < 1.0E-5d) {
                    break;
                } else if (f7 > f4) {
                    f5 = f2;
                } else {
                    f6 = f2;
                }
            }
            q[i] = (f2 * (f2 * f2)) + (f3 * (((1.0f - f2) * 0.5f) + f2));
            f5 = 1.0f;
            while (true) {
                f2 = ((f5 - f) / 2.0f) + f;
                f3 = (3.0f * f2) * (1.0f - f2);
                f7 = ((((1.0f - f2) * 0.5f) + f2) * f3) + ((f2 * f2) * f2);
                if (((double) Math.abs(f7 - f4)) < 1.0E-5d) {
                    break;
                } else if (f7 > f4) {
                    f5 = f2;
                } else {
                    f = f2;
                }
            }
            r[i] = (f2 * (f2 * f2)) + ((((1.0f - f2) * 0.175f) + (0.35000002f * f2)) * f3);
            i++;
            f2 = f6;
        }
        float[] fArr = q;
        r[HttpStatus.SC_MULTIPLE_CHOICES] = 1.0f;
        fArr[HttpStatus.SC_MULTIPLE_CHOICES] = 1.0f;
    }

    static void a(Context context) {
        o = ((context.getResources().getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f;
    }

    by() {
    }

    void a(float f) {
        this.b = this.a + Math.round(((float) (this.c - this.a)) * f);
    }

    private static float a(int i) {
        return i > 0 ? -6000.0f : 6000.0f;
    }

    private void d(int i, int i2, int i3) {
        float abs = Math.abs(((float) (i3 - i)) / ((float) (i2 - i)));
        int i4 = (int) (300.0f * abs);
        if (i4 < HttpStatus.SC_MULTIPLE_CHOICES) {
            float f = ((float) i4) / 300.0f;
            float f2 = ((float) (i4 + 1)) / 300.0f;
            float f3 = r[i4];
            this.h = (int) (((((abs - f) / (f2 - f)) * (r[i4 + 1] - f3)) + f3) * ((float) this.h));
        }
    }

    void a(int i, int i2, int i3) {
        this.k = false;
        this.a = i;
        this.c = i + i2;
        this.g = AnimationUtils.currentAnimationTimeMillis();
        this.h = i3;
        this.f = 0.0f;
        this.d = 0;
    }

    void a() {
        this.b = this.c;
        this.k = true;
    }

    boolean b(int i, int i2, int i3) {
        this.k = true;
        this.c = i;
        this.a = i;
        this.d = 0;
        this.g = AnimationUtils.currentAnimationTimeMillis();
        this.h = 0;
        if (i < i2) {
            e(i, i2, 0);
        } else if (i > i3) {
            e(i, i3, 0);
        }
        if (this.k) {
            return false;
        }
        return true;
    }

    private void e(int i, int i2, int i3) {
        this.k = false;
        this.n = 1;
        this.a = i;
        this.c = i2;
        int i4 = i - i2;
        this.f = a(i4);
        this.d = -i4;
        this.l = Math.abs(i4);
        this.h = (int) (Math.sqrt((((double) i4) * -2.0d) / ((double) this.f)) * 1000.0d);
    }

    void a(int i, int i2, int i3, int i4, int i5) {
        this.l = i5;
        this.k = false;
        this.d = i2;
        this.e = (float) i2;
        this.i = 0;
        this.h = 0;
        this.g = AnimationUtils.currentAnimationTimeMillis();
        this.a = i;
        this.b = i;
        if (i > i4 || i < i3) {
            a(i, i3, i4, i2);
            return;
        }
        this.n = 0;
        double d = 0.0d;
        if (i2 != 0) {
            int d2 = d(i2);
            this.i = d2;
            this.h = d2;
            d = c(i2);
        }
        this.j = (int) (d * ((double) Math.signum((float) i2)));
        this.c = this.j + i;
        if (this.c < i3) {
            d(this.a, this.c, i3);
            this.c = i3;
        }
        if (this.c > i4) {
            d(this.a, this.c, i4);
            this.c = i4;
        }
    }

    void c(int i, int i2, int i3) {
        this.l = 0;
        this.k = false;
        this.d = i3;
        this.e = (float) i3;
        this.i = 0;
        this.h = 0;
        this.g = AnimationUtils.currentAnimationTimeMillis();
        this.a = i;
        this.b = i;
        this.n = 0;
        this.j = i2 - this.a;
        if (this.j * i3 <= 0) {
            this.j = 0;
        }
        this.c = this.a + this.j;
        if (i3 != 0) {
            int i4 = (int) ((1000.0d * ((double) this.j)) / (0.6d * ((double) i3)));
            this.i = i4;
            this.h = i4;
        }
    }

    private double b(int i) {
        return Math.log((double) ((0.35f * ((float) Math.abs(i))) / (this.m * o)));
    }

    private double c(int i) {
        return Math.exp(b(i) * (((double) p) / (((double) p) - 1.0d))) * ((double) (this.m * o));
    }

    private int d(int i) {
        return (int) (Math.exp(b(i) / (((double) p) - 1.0d)) * 1000.0d);
    }

    private void f(int i, int i2, int i3) {
        float sqrt = (float) Math.sqrt((((double) (((((float) (i3 * i3)) / 2.0f) / Math.abs(this.f)) + ((float) Math.abs(i2 - i)))) * 2.0d) / ((double) Math.abs(this.f)));
        this.g -= (long) ((int) ((sqrt - (((float) (-i3)) / this.f)) * 1000.0f));
        this.a = i2;
        this.d = (int) ((-this.f) * sqrt);
    }

    private void g(int i, int i2, int i3) {
        int i4;
        if (i3 == 0) {
            i4 = i - i2;
        } else {
            i4 = i3;
        }
        this.f = a(i4);
        f(i, i2, i3);
        d();
    }

    private void a(int i, int i2, int i3, int i4) {
        boolean z = true;
        if (i <= i2 || i >= i3) {
            int i5;
            boolean z2 = i > i3;
            if (z2) {
                i5 = i3;
            } else {
                i5 = i2;
            }
            int i6 = i - i5;
            if (i6 * i4 < 0) {
                z = false;
            }
            if (z) {
                g(i, i5, i4);
                return;
            } else if (c(i4) > ((double) Math.abs(i6))) {
                a(i, i4, z2 ? i2 : i, z2 ? i : i3, this.l);
                return;
            } else {
                e(i, i5, i4);
                return;
            }
        }
        Log.e("OverScroller", "startAfterEdge called from hatGridView valid position");
        this.k = true;
    }

    private void d() {
        float abs = ((float) (this.d * this.d)) / (Math.abs(this.f) * 2.0f);
        float signum = Math.signum((float) this.d);
        if (abs > ((float) this.l)) {
            this.f = (((-signum) * ((float) this.d)) * ((float) this.d)) / (((float) this.l) * 2.0f);
            abs = (float) this.l;
        }
        this.l = (int) abs;
        this.n = 2;
        int i = this.a;
        if (this.d <= 0) {
            abs = -abs;
        }
        this.c = ((int) abs) + i;
        this.h = -((int) ((1000.0f * ((float) this.d)) / this.f));
    }

    boolean b() {
        switch (this.n) {
            case 0:
                if (this.h < this.i) {
                    this.a = this.c;
                    this.d = (int) this.e;
                    this.f = a(this.d);
                    this.g += (long) this.h;
                    d();
                    break;
                }
                return false;
            case 1:
                return false;
            case 2:
                this.g += (long) this.h;
                e(this.c, this.a, 0);
                break;
        }
        c();
        return true;
    }

    boolean c() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.g;
        if (currentAnimationTimeMillis > ((long) this.h)) {
            return false;
        }
        double d = 0.0d;
        float f;
        float f2;
        float f3;
        switch (this.n) {
            case 0:
                f = ((float) currentAnimationTimeMillis) / ((float) this.i);
                int i = (int) (300.0f * f);
                float f4 = 1.0f;
                f2 = 0.0f;
                if (i < HttpStatus.SC_MULTIPLE_CHOICES) {
                    f4 = ((float) i) / 300.0f;
                    f2 = ((float) (i + 1)) / 300.0f;
                    f3 = q[i];
                    f2 = (q[i + 1] - f3) / (f2 - f4);
                    f4 = ((f - f4) * f2) + f3;
                }
                double d2 = (double) (f4 * ((float) this.j));
                this.e = ((f2 * ((float) this.j)) / ((float) this.i)) * 1000.0f;
                d = d2;
                break;
            case 1:
                f = ((float) currentAnimationTimeMillis) / ((float) this.h);
                float f5 = f * f;
                f3 = Math.signum((float) this.d);
                d = (double) ((((float) this.l) * f3) * ((3.0f * f5) - ((2.0f * f) * f5)));
                this.e = ((-f) + f5) * ((f3 * ((float) this.l)) * 6.0f);
                break;
            case 2:
                f2 = ((float) currentAnimationTimeMillis) / 1000.0f;
                this.e = ((float) this.d) + (this.f * f2);
                d = (double) (((f2 * (this.f * f2)) / 2.0f) + (((float) this.d) * f2));
                break;
        }
        this.b = ((int) Math.round(d)) + this.a;
        return true;
    }
}

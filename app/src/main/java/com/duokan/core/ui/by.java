package com.duokan.core.ui;

import android.content.Context;
import android.util.Log;
import android.view.animation.AnimationUtils;
import org.apache.http.HttpStatus;

class by {
    
    private static float f1044o;
    
    private static float f1045p = ((float) (Math.log(0.78d) / Math.log(0.9d)));
    
    private static final float[] f1046q = new float[HttpStatus.SC_MOVED_PERMANENTLY];
    
    private static final float[] f1047r = new float[HttpStatus.SC_MOVED_PERMANENTLY];
    
    private int f1048a;
    
    private int f1049b;
    
    private int f1050c;
    
    private int f1051d;
    
    private float f1052e;
    
    private float f1053f;
    
    private long f1054g;
    
    private int f1055h;
    
    private int f1056i;
    
    private int f1057j;
    
    private boolean f1058k = true;
    
    private int f1059l;
    
    private float f1060m = 0.005f;
    
    private int f1061n = 0;

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
            f1046q[i] = (f2 * (f2 * f2)) + (f3 * (((1.0f - f2) * 0.5f) + f2));
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
            f1047r[i] = (f2 * (f2 * f2)) + ((((1.0f - f2) * 0.175f) + (0.35000002f * f2)) * f3);
            i++;
            f2 = f6;
        }
        float[] fArr = f1046q;
        f1047r[HttpStatus.SC_MULTIPLE_CHOICES] = 1.0f;
        fArr[HttpStatus.SC_MULTIPLE_CHOICES] = 1.0f;
    }

    
    static void m1725a(Context context) {
        f1044o = ((context.getResources().getDisplayMetrics().density * 160.0f) * 386.0878f) * 0.84f;
    }

    by() {
    }

    
    void m1742a(float f) {
        this.f1049b = this.f1048a + Math.round(((float) (this.f1050c - this.f1048a)) * f);
    }

    
    private static float m1723a(int i) {
        return i > 0 ? -6000.0f : 6000.0f;
    }

    
    private void m1735d(int i, int i2, int i3) {
        float abs = Math.abs(((float) (i3 - i)) / ((float) (i2 - i)));
        int i4 = (int) (300.0f * abs);
        if (i4 < HttpStatus.SC_MULTIPLE_CHOICES) {
            float f = ((float) i4) / 300.0f;
            float f2 = ((float) (i4 + 1)) / 300.0f;
            float f3 = f1047r[i4];
            this.f1055h = (int) (((((abs - f) / (f2 - f)) * (f1047r[i4 + 1] - f3)) + f3) * ((float) this.f1055h));
        }
    }

    
    void m1743a(int i, int i2, int i3) {
        this.f1058k = false;
        this.f1048a = i;
        this.f1050c = i + i2;
        this.f1054g = AnimationUtils.currentAnimationTimeMillis();
        this.f1055h = i3;
        this.f1053f = 0.0f;
        this.f1051d = 0;
    }

    
    void m1741a() {
        this.f1049b = this.f1050c;
        this.f1058k = true;
    }

    
    boolean m1746b(int i, int i2, int i3) {
        this.f1058k = true;
        this.f1050c = i;
        this.f1048a = i;
        this.f1051d = 0;
        this.f1054g = AnimationUtils.currentAnimationTimeMillis();
        this.f1055h = 0;
        if (i < i2) {
            m1737e(i, i2, 0);
        } else if (i > i3) {
            m1737e(i, i3, 0);
        }
        if (this.f1058k) {
            return false;
        }
        return true;
    }

    
    private void m1737e(int i, int i2, int i3) {
        this.f1058k = false;
        this.f1061n = 1;
        this.f1048a = i;
        this.f1050c = i2;
        int i4 = i - i2;
        this.f1053f = m1723a(i4);
        this.f1051d = -i4;
        this.f1059l = Math.abs(i4);
        this.f1055h = (int) (Math.sqrt((((double) i4) * -2.0d) / ((double) this.f1053f)) * 1000.0d);
    }

    
    void m1744a(int i, int i2, int i3, int i4, int i5) {
        this.f1059l = i5;
        this.f1058k = false;
        this.f1051d = i2;
        this.f1052e = (float) i2;
        this.f1056i = 0;
        this.f1055h = 0;
        this.f1054g = AnimationUtils.currentAnimationTimeMillis();
        this.f1048a = i;
        this.f1049b = i;
        if (i > i4 || i < i3) {
            m1724a(i, i3, i4, i2);
            return;
        }
        this.f1061n = 0;
        double d = 0.0d;
        if (i2 != 0) {
            int d2 = m1732d(i2);
            this.f1056i = d2;
            this.f1055h = d2;
            d = m1730c(i2);
        }
        this.f1057j = (int) (d * ((double) Math.signum((float) i2)));
        this.f1050c = this.f1057j + i;
        if (this.f1050c < i3) {
            m1735d(this.f1048a, this.f1050c, i3);
            this.f1050c = i3;
        }
        if (this.f1050c > i4) {
            m1735d(this.f1048a, this.f1050c, i4);
            this.f1050c = i4;
        }
    }

    
    void m1747c(int i, int i2, int i3) {
        this.f1059l = 0;
        this.f1058k = false;
        this.f1051d = i3;
        this.f1052e = (float) i3;
        this.f1056i = 0;
        this.f1055h = 0;
        this.f1054g = AnimationUtils.currentAnimationTimeMillis();
        this.f1048a = i;
        this.f1049b = i;
        this.f1061n = 0;
        this.f1057j = i2 - this.f1048a;
        if (this.f1057j * i3 <= 0) {
            this.f1057j = 0;
        }
        this.f1050c = this.f1048a + this.f1057j;
        if (i3 != 0) {
            int i4 = (int) ((1000.0d * ((double) this.f1057j)) / (0.6d * ((double) i3)));
            this.f1056i = i4;
            this.f1055h = i4;
        }
    }

    
    private double m1728b(int i) {
        return Math.log((double) ((0.35f * ((float) Math.abs(i))) / (this.f1060m * f1044o)));
    }

    
    private double m1730c(int i) {
        return Math.exp(m1728b(i) * (((double) f1045p) / (((double) f1045p) - 1.0d))) * ((double) (this.f1060m * f1044o));
    }

    
    private int m1732d(int i) {
        return (int) (Math.exp(m1728b(i) / (((double) f1045p) - 1.0d)) * 1000.0d);
    }

    
    private void m1739f(int i, int i2, int i3) {
        float sqrt = (float) Math.sqrt((((double) (((((float) (i3 * i3)) / 2.0f) / Math.abs(this.f1053f)) + ((float) Math.abs(i2 - i)))) * 2.0d) / ((double) Math.abs(this.f1053f)));
        this.f1054g -= (long) ((int) ((sqrt - (((float) (-i3)) / this.f1053f)) * 1000.0f));
        this.f1048a = i2;
        this.f1051d = (int) ((-this.f1053f) * sqrt);
    }

    
    private void m1740g(int i, int i2, int i3) {
        int i4;
        if (i3 == 0) {
            i4 = i - i2;
        } else {
            i4 = i3;
        }
        this.f1053f = m1723a(i4);
        m1739f(i, i2, i3);
        m1734d();
    }

    
    private void m1724a(int i, int i2, int i3, int i4) {
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
                m1740g(i, i5, i4);
                return;
            } else if (m1730c(i4) > ((double) Math.abs(i6))) {
                m1744a(i, i4, z2 ? i2 : i, z2 ? i : i3, this.f1059l);
                return;
            } else {
                m1737e(i, i5, i4);
                return;
            }
        }
        Log.e("OverScroller", "startAfterEdge called from a valid position");
        this.f1058k = true;
    }

    
    private void m1734d() {
        float abs = ((float) (this.f1051d * this.f1051d)) / (Math.abs(this.f1053f) * 2.0f);
        float signum = Math.signum((float) this.f1051d);
        if (abs > ((float) this.f1059l)) {
            this.f1053f = (((-signum) * ((float) this.f1051d)) * ((float) this.f1051d)) / (((float) this.f1059l) * 2.0f);
            abs = (float) this.f1059l;
        }
        this.f1059l = (int) abs;
        this.f1061n = 2;
        int i = this.f1048a;
        if (this.f1051d <= 0) {
            abs = -abs;
        }
        this.f1050c = ((int) abs) + i;
        this.f1055h = -((int) ((1000.0f * ((float) this.f1051d)) / this.f1053f));
    }

    
    boolean m1745b() {
        switch (this.f1061n) {
            case 0:
                if (this.f1055h < this.f1056i) {
                    this.f1048a = this.f1050c;
                    this.f1051d = (int) this.f1052e;
                    this.f1053f = m1723a(this.f1051d);
                    this.f1054g += (long) this.f1055h;
                    m1734d();
                    break;
                }
                return false;
            case 1:
                return false;
            case 2:
                this.f1054g += (long) this.f1055h;
                m1737e(this.f1050c, this.f1048a, 0);
                break;
        }
        m1748c();
        return true;
    }

    
    boolean m1748c() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f1054g;
        if (currentAnimationTimeMillis > ((long) this.f1055h)) {
            return false;
        }
        double d = 0.0d;
        float f;
        float f2;
        float f3;
        switch (this.f1061n) {
            case 0:
                f = ((float) currentAnimationTimeMillis) / ((float) this.f1056i);
                int i = (int) (300.0f * f);
                float f4 = 1.0f;
                f2 = 0.0f;
                if (i < HttpStatus.SC_MULTIPLE_CHOICES) {
                    f4 = ((float) i) / 300.0f;
                    f2 = ((float) (i + 1)) / 300.0f;
                    f3 = f1046q[i];
                    f2 = (f1046q[i + 1] - f3) / (f2 - f4);
                    f4 = ((f - f4) * f2) + f3;
                }
                double d2 = (double) (f4 * ((float) this.f1057j));
                this.f1052e = ((f2 * ((float) this.f1057j)) / ((float) this.f1056i)) * 1000.0f;
                d = d2;
                break;
            case 1:
                f = ((float) currentAnimationTimeMillis) / ((float) this.f1055h);
                float f5 = f * f;
                f3 = Math.signum((float) this.f1051d);
                d = (double) ((((float) this.f1059l) * f3) * ((3.0f * f5) - ((2.0f * f) * f5)));
                this.f1052e = ((-f) + f5) * ((f3 * ((float) this.f1059l)) * 6.0f);
                break;
            case 2:
                f2 = ((float) currentAnimationTimeMillis) / 1000.0f;
                this.f1052e = ((float) this.f1051d) + (this.f1053f * f2);
                d = (double) (((f2 * (this.f1053f * f2)) / 2.0f) + (((float) this.f1051d) * f2));
                break;
        }
        this.f1049b = ((int) Math.round(d)) + this.f1048a;
        return true;
    }
}

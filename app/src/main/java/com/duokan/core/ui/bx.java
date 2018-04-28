package com.duokan.core.ui;

import android.content.Context;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;

public class bx {
    /* renamed from: a */
    private int f1039a;
    /* renamed from: b */
    private final by f1040b;
    /* renamed from: c */
    private final by f1041c;
    /* renamed from: d */
    private Interpolator f1042d;
    /* renamed from: e */
    private final boolean f1043e;

    public bx(Context context) {
        this(context, null);
    }

    public bx(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public bx(Context context, Interpolator interpolator, boolean z) {
        this.f1042d = interpolator;
        this.f1043e = z;
        this.f1040b = new by();
        this.f1041c = new by();
        by.m1725a(context);
    }

    /* renamed from: a */
    void m1710a(Interpolator interpolator) {
        this.f1042d = interpolator;
    }

    /* renamed from: a */
    public final boolean m1712a() {
        return this.f1040b.f1058k && this.f1041c.f1058k;
    }

    /* renamed from: a */
    public final void m1711a(boolean z) {
        this.f1040b.f1058k = this.f1041c.f1058k = z;
    }

    /* renamed from: b */
    public final int m1714b() {
        return this.f1040b.f1049b;
    }

    /* renamed from: c */
    public final int m1716c() {
        return this.f1041c.f1049b;
    }

    /* renamed from: d */
    public float m1717d() {
        return this.f1040b.f1052e;
    }

    /* renamed from: e */
    public float m1718e() {
        return this.f1041c.f1052e;
    }

    /* renamed from: f */
    public final int m1719f() {
        return this.f1040b.f1050c;
    }

    /* renamed from: g */
    public final int m1720g() {
        return this.f1041c.f1050c;
    }

    /* renamed from: h */
    public boolean m1721h() {
        if (m1712a()) {
            return false;
        }
        switch (this.f1039a) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.f1040b.f1054g;
                int e = this.f1040b.f1055h;
                if (currentAnimationTimeMillis >= ((long) e)) {
                    m1722i();
                    break;
                }
                float f = ((float) currentAnimationTimeMillis) / ((float) e);
                if (this.f1042d == null) {
                    f = ci.m1762a(f);
                } else {
                    f = this.f1042d.getInterpolation(f);
                }
                this.f1040b.m1742a(f);
                this.f1041c.m1742a(f);
                break;
            case 1:
                if (!(this.f1040b.f1058k || this.f1040b.m1748c() || this.f1040b.m1745b())) {
                    this.f1040b.m1741a();
                }
                if (!(this.f1041c.f1058k || this.f1041c.m1748c() || this.f1041c.m1745b())) {
                    this.f1041c.m1741a();
                    break;
                }
        }
        return true;
    }

    /* renamed from: a */
    public void m1708a(int i, int i2, int i3, int i4, int i5) {
        this.f1039a = 0;
        this.f1040b.m1743a(i, i3, i5);
        this.f1041c.m1743a(i2, i4, i5);
    }

    /* renamed from: a */
    public boolean m1713a(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f1039a = 1;
        boolean b = this.f1040b.m1746b(i, i3, i4);
        boolean b2 = this.f1041c.m1746b(i2, i5, i6);
        if (b || b2) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public void m1709a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.f1043e && !m1712a()) {
            float c = this.f1040b.f1052e;
            float c2 = this.f1041c.f1052e;
            if (Math.signum((float) i3) == Math.signum(c) && Math.signum((float) i4) == Math.signum(c2)) {
                i4 = (int) (((float) i4) + c2);
                i11 = (int) (c + ((float) i3));
                this.f1039a = 1;
                this.f1040b.m1744a(i, i11, i5, i6, i9);
                this.f1041c.m1744a(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.f1039a = 1;
        this.f1040b.m1744a(i, i11, i5, i6, i9);
        this.f1041c.m1744a(i2, i4, i7, i8, i10);
    }

    /* renamed from: b */
    public void m1715b(int i, int i2, int i3, int i4, int i5, int i6) {
        this.f1039a = 1;
        this.f1040b.m1747c(i, i3, i5);
        this.f1041c.m1747c(i2, i4, i6);
    }

    /* renamed from: i */
    public void m1722i() {
        this.f1040b.m1741a();
        this.f1041c.m1741a();
    }
}

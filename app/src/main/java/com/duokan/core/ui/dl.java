package com.duokan.core.ui;

import android.graphics.RectF;

public final class dl extends dp {
    /* renamed from: a */
    protected float f1165a = 1.0f;
    /* renamed from: b */
    protected final RectF f1166b = new RectF(0.0f, 0.0f, 0.0f, 0.0f);

    public dl(float f) {
        m1869a(f);
    }

    public dl(float f, int i, int i2, float f2, float f3, float f4) {
        m1869a(f);
        m1853a(i, i2);
        m1858d(f2);
        m1856b(f3, f4);
    }

    public dl(dl dlVar) {
        m1871a(dlVar);
    }

    /* renamed from: a */
    public float m1868a() {
        return this.f1165a;
    }

    /* renamed from: a */
    public void m1869a(float f) {
        this.f1165a = f;
    }

    /* renamed from: b */
    public float m1872b() {
        return this.f1166b.left;
    }

    /* renamed from: c */
    public float m1873c() {
        return this.f1166b.top;
    }

    /* renamed from: d */
    public float m1874d() {
        return this.f1166b.right;
    }

    /* renamed from: e */
    public float m1875e() {
        return this.f1166b.bottom;
    }

    /* renamed from: a */
    public void m1870a(float f, float f2, float f3, float f4) {
        this.f1166b.set(f, f2, f3, f4);
    }

    /* renamed from: a */
    public void m1871a(dl dlVar) {
        super.m1854a(dlVar);
        this.f1165a = dlVar.f1165a;
        this.f1166b.set(dlVar.f1166b);
    }
}

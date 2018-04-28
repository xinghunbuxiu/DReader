package com.duokan.core.ui;

import android.graphics.Point;
import android.graphics.PointF;

public abstract class dp {
    /* renamed from: a */
    private PointF f1158a = new PointF(0.5f, 0.5f);
    /* renamed from: b */
    private Point f1159b = new Point(0, 0);
    /* renamed from: c */
    private float f1160c = 0.0f;
    /* renamed from: d */
    private float f1161d = 0.0f;
    /* renamed from: e */
    private float f1162e = 0.0f;
    /* renamed from: f */
    private float f1163f = 1.0f;
    /* renamed from: g */
    private float f1164g = 1.0f;

    /* renamed from: f */
    public float m1859f() {
        return this.f1158a.x;
    }

    /* renamed from: g */
    public float m1860g() {
        return this.f1158a.y;
    }

    /* renamed from: a */
    public void m1852a(float f, float f2) {
        this.f1158a.x = f;
        this.f1158a.y = f2;
    }

    /* renamed from: h */
    public int m1861h() {
        return this.f1159b.x;
    }

    /* renamed from: i */
    public int m1862i() {
        return this.f1159b.y;
    }

    /* renamed from: a */
    public void m1853a(int i, int i2) {
        this.f1159b.x = i;
        this.f1159b.y = i2;
    }

    /* renamed from: j */
    public float m1863j() {
        return this.f1160c;
    }

    /* renamed from: b */
    public void m1855b(float f) {
        this.f1160c = f;
    }

    /* renamed from: k */
    public float m1864k() {
        return this.f1161d;
    }

    /* renamed from: c */
    public void m1857c(float f) {
        this.f1161d = f;
    }

    /* renamed from: l */
    public float m1865l() {
        return this.f1162e;
    }

    /* renamed from: d */
    public void m1858d(float f) {
        this.f1162e = f;
    }

    /* renamed from: m */
    public float m1866m() {
        return this.f1163f;
    }

    /* renamed from: n */
    public float m1867n() {
        return this.f1164g;
    }

    /* renamed from: b */
    public void m1856b(float f, float f2) {
        this.f1163f = f;
        this.f1164g = f2;
    }

    /* renamed from: a */
    public void m1854a(dp dpVar) {
        this.f1158a.set(dpVar.f1158a);
        this.f1159b.set(dpVar.f1159b.x, dpVar.f1159b.y);
        this.f1160c = dpVar.f1160c;
        this.f1161d = dpVar.f1161d;
        this.f1162e = dpVar.f1162e;
        this.f1163f = dpVar.f1163f;
        this.f1164g = dpVar.f1164g;
    }
}

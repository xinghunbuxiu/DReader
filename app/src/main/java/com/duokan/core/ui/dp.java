package com.duokan.core.ui;

import android.graphics.Point;
import android.graphics.PointF;

public abstract class dp {
    private PointF a = new PointF(0.5f, 0.5f);
    private Point b = new Point(0, 0);
    private float c = 0.0f;
    private float d = 0.0f;
    private float e = 0.0f;
    private float f = 1.0f;
    private float g = 1.0f;

    public float f() {
        return this.a.x;
    }

    public float g() {
        return this.a.y;
    }

    public void a(float f, float f2) {
        this.a.x = f;
        this.a.y = f2;
    }

    public int h() {
        return this.b.x;
    }

    public int i() {
        return this.b.y;
    }

    public void a(int i, int i2) {
        this.b.x = i;
        this.b.y = i2;
    }

    public float j() {
        return this.c;
    }

    public void b(float f) {
        this.c = f;
    }

    public float k() {
        return this.d;
    }

    public void c(float f) {
        this.d = f;
    }

    public float l() {
        return this.e;
    }

    public void d(float f) {
        this.e = f;
    }

    public float m() {
        return this.f;
    }

    public float n() {
        return this.g;
    }

    public void b(float f, float f2) {
        this.f = f;
        this.g = f2;
    }

    public void a(dp dpVar) {
        this.a.set(dpVar.a);
        this.b.set(dpVar.b.x, dpVar.b.y);
        this.c = dpVar.c;
        this.d = dpVar.d;
        this.e = dpVar.e;
        this.f = dpVar.f;
        this.g = dpVar.g;
    }
}

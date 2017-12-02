package com.duokan.reader.domain.document;

import android.graphics.Bitmap;
import android.graphics.Rect;

public abstract class az {
    private boolean a = false;
    private boolean b = false;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private float f = 1.2f;
    private float g = 0.0f;
    private float h = 4.0f;
    private float i = 0.0f;
    private int j = 12;
    private int k = 0;

    protected abstract void b(Bitmap bitmap, Rect rect);

    protected abstract void i();

    protected abstract void j();

    public int a() {
        return this.c;
    }

    public void a(int i) {
        if (this.c != i) {
            this.c = i;
            m();
        }
    }

    public int b() {
        l();
        return this.d;
    }

    public int c() {
        l();
        return this.e;
    }

    public float d() {
        return this.f;
    }

    public void a(float f) {
        if (this.f != f) {
            this.f = f;
            m();
        }
    }

    public float e() {
        return this.g;
    }

    public void b(float f) {
        if (this.g != f) {
            this.g = f;
            m();
        }
    }

    public float f() {
        return this.h;
    }

    public void c(float f) {
        if (this.h != f) {
            this.h = f;
            m();
        }
    }

    public float g() {
        return this.i;
    }

    public void d(float f) {
        if (this.i != f) {
            this.i = f;
            m();
        }
    }

    public float h() {
        return (float) this.j;
    }

    public void b(int i) {
        if (this.j != i) {
            this.j = i;
            m();
        }
    }

    public void c(int i) {
        this.k = i;
    }

    public void a(Bitmap bitmap, Rect rect) {
        k();
        b(bitmap, rect);
    }

    private void k() {
        l();
        if (!this.b) {
            j();
            this.b = true;
        }
    }

    private void l() {
        if (!this.a) {
            i();
            this.a = true;
        }
    }

    private void m() {
        this.a = false;
        this.b = false;
    }

    protected void a(int i, int i2) {
        this.d = i;
        this.e = i2;
    }
}

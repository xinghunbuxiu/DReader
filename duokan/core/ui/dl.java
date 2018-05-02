package com.duokan.core.ui;

import android.graphics.RectF;

public final class dl extends dp {
    protected float a = 1.0f;
    protected final RectF b = new RectF(0.0f, 0.0f, 0.0f, 0.0f);

    public dl(float f) {
        a(f);
    }

    public dl(float f, int i, int i2, float f2, float f3, float f4) {
        a(f);
        a(i, i2);
        d(f2);
        b(f3, f4);
    }

    public dl(dl dlVar) {
        a(dlVar);
    }

    public float a() {
        return this.a;
    }

    public void a(float f) {
        this.a = f;
    }

    public float b() {
        return this.b.left;
    }

    public float c() {
        return this.b.top;
    }

    public float d() {
        return this.b.right;
    }

    public float e() {
        return this.b.bottom;
    }

    public void a(float f, float f2, float f3, float f4) {
        this.b.set(f, f2, f3, f4);
    }

    public void a(dl dlVar) {
        super.a(dlVar);
        this.a = dlVar.a;
        this.b.set(dlVar.b);
    }
}

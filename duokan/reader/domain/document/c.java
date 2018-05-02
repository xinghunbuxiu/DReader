package com.duokan.reader.domain.document;

import android.graphics.PointF;

public class c {
    private final float a;
    private final PointF b;
    private final PointF c;
    private final float d;
    private final float e;
    private az f;
    private az g;

    public c(PointF pointF, PointF pointF2, float f, float f2, float f3) {
        this.a = f;
        this.b = pointF;
        this.c = pointF2;
        this.d = f2;
        this.e = f3;
    }

    public float a() {
        return this.a;
    }

    public PointF b() {
        return this.b;
    }

    public float c() {
        return this.d;
    }

    public PointF d() {
        return this.c;
    }

    public az e() {
        return this.f;
    }

    public az f() {
        return this.g;
    }

    public void a(az azVar) {
        this.f = azVar;
    }

    public void b(az azVar) {
        this.g = azVar;
    }
}

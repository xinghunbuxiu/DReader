package com.duokan.reader.domain.document;

import android.graphics.Bitmap;
import android.graphics.Rect;

public abstract class az {
    /* renamed from: a */
    private boolean f4432a = false;
    /* renamed from: b */
    private boolean f4433b = false;
    /* renamed from: c */
    private int f4434c = 0;
    /* renamed from: d */
    private int f4435d = 0;
    /* renamed from: e */
    private int f4436e = 0;
    /* renamed from: f */
    private float f4437f = 1.2f;
    /* renamed from: g */
    private float f4438g = 0.0f;
    /* renamed from: h */
    private float f4439h = 4.0f;
    /* renamed from: i */
    private float f4440i = 0.0f;
    /* renamed from: j */
    private int f4441j = 12;
    /* renamed from: k */
    private int f4442k = 0;

    /* renamed from: b */
    protected abstract void mo1424b(Bitmap bitmap, Rect rect);

    /* renamed from: i */
    protected abstract void mo1425i();

    /* renamed from: j */
    protected abstract void mo1426j();

    /* renamed from: a */
    public int m6402a() {
        return this.f4434c;
    }

    /* renamed from: a */
    public void m6404a(int i) {
        if (this.f4434c != i) {
            this.f4434c = i;
            m6401m();
        }
    }

    /* renamed from: b */
    public int m6407b() {
        m6400l();
        return this.f4435d;
    }

    /* renamed from: c */
    public int m6411c() {
        m6400l();
        return this.f4436e;
    }

    /* renamed from: d */
    public float m6414d() {
        return this.f4437f;
    }

    /* renamed from: a */
    public void m6403a(float f) {
        if (this.f4437f != f) {
            this.f4437f = f;
            m6401m();
        }
    }

    /* renamed from: e */
    public float m6416e() {
        return this.f4438g;
    }

    /* renamed from: b */
    public void m6408b(float f) {
        if (this.f4438g != f) {
            this.f4438g = f;
            m6401m();
        }
    }

    /* renamed from: f */
    public float m6417f() {
        return this.f4439h;
    }

    /* renamed from: c */
    public void m6412c(float f) {
        if (this.f4439h != f) {
            this.f4439h = f;
            m6401m();
        }
    }

    /* renamed from: g */
    public float m6418g() {
        return this.f4440i;
    }

    /* renamed from: d */
    public void m6415d(float f) {
        if (this.f4440i != f) {
            this.f4440i = f;
            m6401m();
        }
    }

    /* renamed from: h */
    public float m6419h() {
        return (float) this.f4441j;
    }

    /* renamed from: b */
    public void m6409b(int i) {
        if (this.f4441j != i) {
            this.f4441j = i;
            m6401m();
        }
    }

    /* renamed from: c */
    public void m6413c(int i) {
        this.f4442k = i;
    }

    /* renamed from: a */
    public void m6406a(Bitmap bitmap, Rect rect) {
        m6399k();
        mo1424b(bitmap, rect);
    }

    /* renamed from: k */
    private void m6399k() {
        m6400l();
        if (!this.f4433b) {
            mo1426j();
            this.f4433b = true;
        }
    }

    /* renamed from: l */
    private void m6400l() {
        if (!this.f4432a) {
            mo1425i();
            this.f4432a = true;
        }
    }

    /* renamed from: m */
    private void m6401m() {
        this.f4432a = false;
        this.f4433b = false;
    }

    /* renamed from: a */
    protected void m6405a(int i, int i2) {
        this.f4435d = i;
        this.f4436e = i2;
    }
}

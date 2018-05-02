package com.duokan.reader.common;

/* renamed from: com.duokan.reader.common.a */
public abstract class C0516a {
    /* renamed from: a */
    protected String f1749a;
    /* renamed from: b */
    private boolean f1750b = false;

    /* renamed from: b */
    protected abstract void mo1137b();

    protected C0516a(String str) {
        this.f1749a = str;
    }

    /* renamed from: a */
    public final void m2226a() {
        if (!this.f1750b) {
            this.f1750b = true;
            mo1137b();
            this.f1749a = null;
        }
    }
}

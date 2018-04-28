package com.duokan.core.sys;

public class af<T> {
    /* renamed from: a */
    private T f635a;
    /* renamed from: b */
    private boolean f636b;

    public af() {
        this.f635a = null;
        this.f636b = false;
    }

    public af(T t) {
        this.f635a = null;
        this.f635a = t;
        this.f636b = true;
    }

    /* renamed from: a */
    public T m858a() {
        return this.f635a;
    }

    /* renamed from: a */
    public void mo975a(T t) {
        this.f635a = t;
        this.f636b = true;
    }

    /* renamed from: b */
    public boolean m861b() {
        return this.f636b;
    }

    /* renamed from: b */
    public boolean m862b(T t) {
        if (!this.f636b) {
            return false;
        }
        if (this.f635a != null && t != null) {
            return this.f635a.equals(t);
        }
        if (this.f635a == t) {
            return true;
        }
        return false;
    }

    /* renamed from: c */
    public void m863c() {
        this.f635a = null;
        this.f636b = false;
    }

    /* renamed from: a */
    public void m859a(af<T> afVar) {
        this.f635a = afVar.f635a;
        this.f636b = afVar.f636b;
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        af afVar = (af) obj;
        if (this.f636b && afVar.f636b) {
            return m862b(afVar.f635a);
        }
        if (this.f636b == afVar.f636b) {
            return true;
        }
        return false;
    }
}

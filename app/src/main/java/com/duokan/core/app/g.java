package com.duokan.core.app;

import android.content.Context;

import java.lang.ref.WeakReference;

final class g extends x {
    private final y a;
    private final WeakReference b;

    protected g(y yVar, e eVar) {
        super(b.a((Context) yVar));
        this.a = yVar;
        this.b = new WeakReference(eVar);
    }

    public k a(Class cls) {
        if (((e) this.b.get()) == null) {
            return null;
        }
        return super.a(cls);
    }

    public k queryFeature(Class cls) {
        k a = a(cls);
        if (a != null) {
            return a;
        }
        y b = b();
        if (b != null) {
            a = b.queryFeature(cls);
        }
        if (a != null) {
            return a;
        }
        y c = c();
        if (!(c == null || c == b)) {
            a = c.queryFeature(cls);
        }
        if (a == null) {
            return a().queryFeature(cls);
        }
        return a;
    }

    private final y b() {
        e eVar = (e) this.b.get();
        if (eVar == null) {
            return null;
        }
        h parent = eVar.getParent();
        if (parent == null) {
            return null;
        }
        return parent.getContext();
    }

    private final y c() {
        return this.a;
    }
}

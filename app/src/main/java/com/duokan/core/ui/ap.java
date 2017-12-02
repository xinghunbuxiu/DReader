package com.duokan.core.ui;

import android.view.View;
import android.view.ViewGroup;

class ap extends aj implements ax {
    final /* synthetic */ HatGridView a;
    private aj c;

    private ap(HatGridView hatGridView) {
        this.a = hatGridView;
        this.c = null;
    }

    public final aj b() {
        return this.c;
    }

    public final void a(aj ajVar) {
        if (this.c != null) {
            this.c.b(this);
        }
        this.c = ajVar;
        if (this.c != null) {
            this.c.a(this);
        }
    }

    public int a() {
        return this.c == null ? 0 : this.c.a();
    }

    public int a(int i) {
        return this.c == null ? 0 : this.c.a(i);
    }

    public View a(int i, View view, ViewGroup viewGroup) {
        return this.c == null ? null : this.c.a(i, view, viewGroup);
    }

    public int c() {
        return this.c == null ? 0 : this.c.c();
    }

    public View a(View view, ViewGroup viewGroup) {
        return this.c == null ? null : this.c.a(null, viewGroup);
    }

    public View b(int i, View view, ViewGroup viewGroup) {
        return this.c == null ? null : this.c.b(i, view, viewGroup);
    }

    public View c(int i, View view, ViewGroup viewGroup) {
        return this.c == null ? null : this.c.c(i, view, viewGroup);
    }

    public View d(int i, View view, ViewGroup viewGroup) {
        return this.c == null ? null : this.c.d(i, view, viewGroup);
    }

    public void a_(int i, int i2) {
        f(i, i2);
    }

    public void b_(int i, int i2) {
        g(i, i2);
    }

    public void a(int i, int i2, int i3) {
        b(i, i2, i3);
    }

    public void d(int i, int i2) {
        h(i, i2);
    }

    public void a_(int i) {
        View z = this.a.l();
        View b = b(i, z, this.a.c);
        if (z != b) {
            this.a.a(b);
        }
        z = this.a.m();
        b = c(i, z, this.a.b);
        if (z != b) {
            this.a.b(b);
        }
        d();
    }

    public Object d(int i) {
        return this.c == null ? null : this.c.d(i);
    }
}

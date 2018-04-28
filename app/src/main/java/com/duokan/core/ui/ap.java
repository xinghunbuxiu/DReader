package com.duokan.core.ui;

import android.view.View;
import android.view.ViewGroup;

class ap extends aj implements ax {
    /* renamed from: a */
    final /* synthetic */ HatGridView f962a;
    /* renamed from: c */
    private aj f963c;

    private ap(HatGridView hatGridView) {
        this.f962a = hatGridView;
        this.f963c = null;
    }

    /* renamed from: b */
    public final aj m1593b() {
        return this.f963c;
    }

    /* renamed from: a */
    public final void m1591a(aj ajVar) {
        if (this.f963c != null) {
            this.f963c.mo484b(this);
        }
        this.f963c = ajVar;
        if (this.f963c != null) {
            this.f963c.mo483a(this);
        }
    }

    /* renamed from: a */
    public int mo486a() {
        return this.f963c == null ? 0 : this.f963c.mo486a();
    }

    /* renamed from: a */
    public int mo487a(int i) {
        return this.f963c == null ? 0 : this.f963c.mo487a(i);
    }

    /* renamed from: a */
    public View mo488a(int i, View view, ViewGroup viewGroup) {
        return this.f963c == null ? null : this.f963c.mo488a(i, view, viewGroup);
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f963c == null ? 0 : this.f963c.mo506c();
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        return this.f963c == null ? null : this.f963c.mo482a(null, viewGroup);
    }

    /* renamed from: b */
    public View mo505b(int i, View view, ViewGroup viewGroup) {
        return this.f963c == null ? null : this.f963c.mo505b(i, view, viewGroup);
    }

    /* renamed from: c */
    public View mo507c(int i, View view, ViewGroup viewGroup) {
        return this.f963c == null ? null : this.f963c.mo507c(i, view, viewGroup);
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        return this.f963c == null ? null : this.f963c.mo508d(i, view, viewGroup);
    }

    public void a_(int i, int i2) {
        m1397f(i, i2);
    }

    public void b_(int i, int i2) {
        m1398g(i, i2);
    }

    /* renamed from: a */
    public void mo440a(int i, int i2, int i3) {
        m1393b(i, i2, i3);
    }

    /* renamed from: d */
    public void mo444d(int i, int i2) {
        mo2519h(i, i2);
    }

    public void a_(int i) {
        View A = this.f962a.m1214l();
        View b = mo505b(i, A, this.f962a.f813c);
        if (A != b) {
            this.f962a.m1190a(b);
        }
        A = this.f962a.m1216m();
        b = mo507c(i, A, this.f962a.f812b);
        if (A != b) {
            this.f962a.m1198b(b);
        }
        mo1691d();
    }

    /* renamed from: d */
    public Object mo509d(int i) {
        return this.f963c == null ? null : this.f963c.mo509d(i);
    }
}

package com.duokan.reader.ui.reading;

import android.graphics.drawable.ColorDrawable;

import com.duokan.reader.domain.bookshelf.eg;

class acf implements x {
    final /* synthetic */ TextSelectionController a;

    acf(TextSelectionController textSelectionController) {
        this.a = textSelectionController;
    }

    public void d() {
        this.a.i();
    }

    public void e() {
        this.a.h.a(this.a.h(), this.a.f());
        this.a.i();
    }

    public void b() {
        this.a.l = this.a.h.a(this.a.h(), this.a.f(), "");
        this.a.e.setSelectionDrawable(new ColorDrawable(0));
        this.a.e.setShowSelectionIndicators(false);
    }

    public void c() {
        this.a.h.c(this.a.l);
        this.a.i();
    }

    public void f() {
        this.a.h.a(this.a.h().g(), this.a.f());
        this.a.i();
    }

    public void a() {
        this.a.h.a(this.a.f());
        this.a.i();
    }

    public void a(int i) {
        eg.a().a(i);
        this.a.l.a(eg.a().b());
        this.a.h.d(this.a.l);
        this.a.i();
    }

    public void g() {
        this.a.h.b(this.a.l);
        this.a.i();
    }
}

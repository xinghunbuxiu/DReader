package com.duokan.reader.ui;

import android.view.View;

import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.core.sys.t;

public abstract class p extends e implements e {
    private final i a = new q(this, getContext());

    public p(y yVar) {
        super(yVar);
        setContentView(this.a.getContentView());
        addSubController(this.a);
        activate(this.a);
    }

    public void a(View view) {
        this.a.a(view);
    }

    public int g() {
        return this.a.i();
    }

    public void a(int i) {
        this.a.c(i);
    }

    public void h() {
        this.a.dismissAllPopups();
    }

    public boolean a(e eVar) {
        activate(this.a);
        return this.a.a(eVar);
    }

    public boolean a(e eVar, Runnable runnable) {
        activate(this.a);
        return this.a.a(eVar, runnable);
    }

    public boolean i() {
        return this.a.j();
    }

    public boolean j() {
        return this.a.k();
    }

    public boolean a(Runnable runnable) {
        return this.a.b(runnable);
    }

    public void c_(int i) {
    }

    public void c(int i) {
    }

    public boolean pushPage(e eVar) {
        activate(this.a);
        return this.a.c(eVar);
    }

    public boolean pushPageSmoothly(e eVar, Runnable runnable) {
        activate(this.a);
        return this.a.c(eVar, runnable);
    }

    public boolean b(e eVar) {
        activate(this.a);
        return this.a.b(eVar);
    }

    public boolean b(e eVar, Runnable runnable) {
        activate(this.a);
        return this.a.b(eVar, runnable);
    }

    public boolean showPopupSmoothly(e eVar, Runnable runnable) {
        if (!showPopup(eVar)) {
            return false;
        }
        t.b(runnable);
        return true;
    }

    public boolean showPopup(e eVar) {
        activate(this.a);
        if (this.a.showPopup(eVar)) {
            return true;
        }
        return false;
    }

    public boolean showPopup(e eVar, int i, int i2) {
        activate(this.a);
        if (this.a.showPopup(eVar, i, i2)) {
            return true;
        }
        return false;
    }
}

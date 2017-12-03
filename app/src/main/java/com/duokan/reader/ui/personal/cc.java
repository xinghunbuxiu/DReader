package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.ui.bookshelf.ho;

public class cc extends ActivatedController implements ho {
    private final cd a = new cd(getContext(), this);

    public cc(IFeature featrue) {
        super(featrue);
        setContentView(this.a);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.a.b(true);
        }
    }

    protected boolean onBack() {
        if (this.a == null || !this.a.j()) {
            return super.onBack();
        }
        return true;
    }

    public void a(int i, int i2) {
        this.a.c(i, i2);
    }

    public void b() {
        this.a.q();
    }

    public void c() {
        this.a.m();
    }

    public void d() {
        this.a.n();
    }

    public void a(Runnable runnable) {
        this.a.a(runnable);
    }

    public int e() {
        return this.a.getSelectedCount();
    }

    public void f() {
        this.a.a();
    }

    public boolean g() {
        return this.a.c();
    }

    public void h() {
        this.a.b();
    }

    public void b(int i, int i2) {
        this.a.b(i, i2);
    }

    public String i() {
        return getString(j.personal__message_center_view__edit_title);
    }

    public String j() {
        return getString(j.personal__message_center_view__edit_selected);
    }

    public String k() {
        return null;
    }
}

package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.cloud.push.a;
import com.duokan.reader.ui.bookshelf.ho;

import java.util.ArrayList;

public class cr extends ActivatedController implements a, ho {
    private final ct a = new ct(this, getContext(), this);
    private final ArrayList b = new ArrayList();

    public cr(IFeature featrue) {
        super(featrue);
        setContentView(this.a);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.a.b(true);
            l();
            b.a().a((a) this);
        } else {
            this.a.b(true);
            l();
            b.a().a((a) this);
        }
    }

    protected void onDeactive() {
        b.a().b((a) this);
        super.onDeactive();
    }

    public void a() {
        if (b.a().c() > 0) {
            this.a.a(0, 0);
            l();
        }
    }

    private void l() {
        getContentView().postDelayed(new cs(this), 3000);
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
        return getString(j.personal__message_push_view__edit_title);
    }

    public String j() {
        return getString(j.personal__message_push_view__edit_selected);
    }

    public String k() {
        return null;
    }
}

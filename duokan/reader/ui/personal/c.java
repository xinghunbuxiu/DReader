package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.ui.bookshelf.ho;
import com.duokan.reader.ui.general.ap;

public class c extends ActivatedController implements ho {
    private final ActivatedController a = new ActivatedController(getContext(), this);

    public c(IFeature featrue) {
        super(featrue);
        setContentView(this.a);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.a.e_();
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
        ap apVar = new ap(getContext());
        apVar.setPrompt(j.personal__auto_buy_view__delete_multiple);
        apVar.setCancelLabel(j.general__shared__cancel);
        apVar.setOkLabel(j.general__shared__ok);
        apVar.setCancelOnBack(true);
        apVar.setCancelOnTouchOutside(false);
        apVar.open(new d(this, runnable));
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
    }

    public String i() {
        return null;
    }

    public String j() {
        return null;
    }

    public String k() {
        return getString(j.personal__auto_buy_view__delete_text);
    }
}

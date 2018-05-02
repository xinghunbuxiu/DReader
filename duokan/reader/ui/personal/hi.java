package com.duokan.reader.ui.personal;

import com.duokan.c.j;
import com.duokan.core.app.IFeature;
import com.duokan.reader.ui.bookshelf.ho;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.hd;

public class hi extends hd implements ho {
    private final hl a = new hl(getContext(), this.b, this);
    private final mo b = new fa();

    public hi(IFeature featrue) {
        super(featrue);
        setContentView(this.a);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.a.a(0, 30);
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
        if (getPopupCount() <= 0) {
            ap apVar = new ap(getContext());
            apVar.setPrompt(j.personal__statistics_view__delete);
            apVar.setCancelLabel(j.general__shared__cancel);
            apVar.setOkLabel(j.general__shared__remove);
            apVar.setCancelOnBack(true);
            apVar.setCancelOnTouchOutside(false);
            apVar.open(new hj(this, runnable));
        }
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
        return null;
    }
}

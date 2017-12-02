package com.duokan.reader.ui.reading;

import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;

import com.duokan.core.app.y;
import com.duokan.reader.domain.document.au;
import com.duokan.reader.ui.general.gi;
import com.duokan.reader.ui.general.hd;

public class hp extends si {
    private hq i;
    private kd j = null;

    public /* bridge */ /* synthetic */ void a(au auVar, Rect rect) {
        super.a(auVar, rect);
    }

    public /* bridge */ /* synthetic */ boolean a(PointF pointF, Runnable runnable, Runnable runnable2) {
        return super.a(pointF, runnable, runnable2);
    }

    public /* bridge */ /* synthetic */ boolean b(PointF pointF, Runnable runnable, Runnable runnable2) {
        return super.b(pointF, runnable, runnable2);
    }

    public /* bridge */ /* synthetic */ boolean e() {
        return super.e();
    }

    public /* bridge */ /* synthetic */ boolean f() {
        return super.f();
    }

    public /* bridge */ /* synthetic */ void g() {
        super.g();
    }

    public /* bridge */ /* synthetic */ void h() {
        super.h();
    }

    public /* bridge */ /* synthetic */ void i() {
        super.i();
    }

    public /* bridge */ /* synthetic */ void j() {
        super.j();
    }

    public /* bridge */ /* synthetic */ boolean k() {
        return super.k();
    }

    public /* bridge */ /* synthetic */ void l() {
        super.l();
    }

    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    public /* bridge */ /* synthetic */ void n() {
        super.n();
    }

    public /* bridge */ /* synthetic */ void o() {
        super.o();
    }

    public hp(y yVar, sh shVar, wl wlVar) {
        super(yVar, shVar, wlVar);
    }

    protected hd a() {
        this.i = new hq(getContext());
        return this.i;
    }

    protected View b() {
        return this.i.m();
    }

    protected View c() {
        return this.i.n();
    }

    protected View d() {
        return this.i.o();
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        kd.a();
    }

    public void a(gi giVar) {
        super.a(giVar);
        if (this.j == null && this.a.G().k() && kd.b()) {
            this.j = new kd(getContext());
            this.b.addView(this.j.getContentView());
            addSubController(this.j);
            activate(this.j);
        }
        if (this.j != null) {
            this.j.a(giVar);
        }
    }
}

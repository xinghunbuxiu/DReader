package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.UTools;
import com.duokan.core.ui.ge;
import com.duokan.reader.domain.document.aj;

public class mv extends fy implements mn {
    static final /* synthetic */ boolean c = (!mv.class.desiredAssertionStatus());
    private boolean b = false;
    private ge d;
    private me e;
    private mq f;

    public mv(Context context, aj ajVar) {
        super(context);
        this.e = new me(context, ajVar, this);
        a(this.e, null);
        super.setOnZoomListener(new mw(this));
    }

    public void setTopLayerAssistant(mq mqVar) {
        this.f = mqVar;
    }

    public void setOnZoomListener(ge geVar) {
        this.d = geVar;
    }

    public void a(Runnable runnable) {
        super.a(runnable);
        this.e.a();
        if (c || this.f != null) {
            this.f.a(-1);
            return;
        }
        throw new AssertionError();
    }

    public void j() {
        this.e.a(-1);
    }

    public void d() {
        super.d();
        if (c || this.f != null) {
            this.b = true;
            this.f.c();
            return;
        }
        throw new AssertionError();
    }

    public void e() {
        super.e();
        this.e.setShowClearImage(true);
    }

    public void f() {
        super.f();
        this.e.setShowClearImage(false);
    }

    public void h() {
        super.h();
        if (c || this.f != null) {
            this.b = false;
            this.f.a();
            return;
        }
        throw new AssertionError();
    }

    public void g() {
        super.g();
        if (c || this.f != null) {
            this.b = false;
            this.f.a();
            return;
        }
        throw new AssertionError();
    }

    public void a(int i, boolean z) {
        this.e.a();
        super.a(i, z);
    }

    protected boolean a(PointF pointF) {
        if (this.e.a(UTools.addAnimation(new PointF(pointF.x + ((float) getScrollX()), pointF.y + ((float) getScrollY())), (View) this, this.e))) {
            return true;
        }
        return super.a(pointF);
    }

    public void a() {
        this.e.c();
    }

    public void b() {
        this.e.b();
    }

    public void a(int i) {
        this.e.a(i);
    }

    public PointF a(View view, int i) {
        return this.e.a(view, i);
    }

    public void a(int i, float f, float f2, float f3) {
        if (c || this.f != null) {
            this.f.a(i);
            b(f2, f3, f * i(), null, null);
            return;
        }
        throw new AssertionError();
    }
}

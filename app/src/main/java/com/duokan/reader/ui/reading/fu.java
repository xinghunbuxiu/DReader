package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.b.e;
import com.duokan.core.ui.dv;
import com.duokan.core.ui.ge;
import com.duokan.reader.domain.document.au;

public abstract class fu extends FrameLayout {
    private final gn a;
    private final au b;
    private boolean c = false;
    private boolean d = true;
    private final Rect e;
    private fx f;
    private final Drawable g;
    private final fy h;
    private la i;

    public abstract fy a(au auVar);

    public fu(Context context, gn gnVar, Rect rect, au auVar) {
        super(context);
        this.a = gnVar;
        this.b = auVar;
        setWillNotDraw(false);
        this.e = rect;
        this.h = a(auVar);
        addView(this.h, new LayoutParams(-1, -1));
        this.g = getResources().getDrawable(e.reading__shared__pic_shadow_normal);
        this.h.setEnabled(false);
        this.h.setQuitRunnable(new fv(this));
    }

    public final gn getPagePresenter() {
        return this.a;
    }

    public final au getImage() {
        return this.b;
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        return true;
    }

    public boolean c() {
        return true;
    }

    public final Rect getOriginBounds() {
        return this.e;
    }

    public float getZoomFactor() {
        return this.h.getZoomFactor();
    }

    public float getZoomAngle() {
        return this.h.getZoomAngle();
    }

    public fy getWatchingView() {
        return this.h;
    }

    public final void setImageBrowser(la laVar) {
        this.i = laVar;
    }

    public void setZoomListener(ge geVar) {
        this.h.setOnZoomListener(geVar);
    }

    public void d() {
        l();
    }

    public void e() {
        k();
    }

    public final void f() {
        this.h.d();
    }

    public final void g() {
        this.h.e();
    }

    public final void h() {
        m();
        this.h.f();
    }

    public final void i() {
        e();
        this.c = true;
        this.h.g();
        this.h.setEnabled(true);
    }

    public final void j() {
        this.c = false;
        this.h.h();
        this.h.setEnabled(false);
    }

    public void a(int i, boolean z) {
        this.h.a(i, z);
        if (this.f != null) {
            this.f.setVisibility(4);
            dv.a(this.f, new fw(this));
        }
    }

    public void k() {
        if (this.f != null) {
            this.f.a();
        }
    }

    public void l() {
        if (this.f != null) {
            this.f.b();
        }
    }

    public void m() {
        if (this.f != null) {
            this.f.c();
        }
    }

    public void n() {
        if (this.f != null) {
            this.f.d();
        }
    }

    protected final boolean o() {
        return this.c;
    }

    protected void a(Runnable runnable) {
        this.h.a(runnable);
    }

    protected final void p() {
        if (this.i != null) {
            this.i.d(this);
        }
    }

    protected final void q() {
        if (this.i != null) {
            this.i.c(this);
        }
    }

    protected final void setDrawBorder(boolean z) {
        this.d = z;
    }

    protected final void a(View view, LayoutParams layoutParams) {
        if (this.f == null) {
            this.f = new fx(this, getContext());
            addView(this.f, new LayoutParams(-1, -2, 80));
        }
        this.f.removeAllViews();
        fx fxVar = this.f;
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -2);
        }
        fxVar.addView(view, layoutParams);
        this.f.c();
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!this.c && this.d) {
            Rect rect = new Rect(0, 0, getWidth(), getHeight());
            rect.inset(-21, -21);
            this.g.setBounds(rect);
            this.g.draw(canvas);
        }
    }
}

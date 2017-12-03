package com.duokan.reader.ui.reading;

import android.graphics.Color;
import android.graphics.PointF;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.er;
import com.duokan.core.ui.et;
import com.duokan.reader.ui.reading.a.ag;
import com.duokan.reader.ui.reading.a.ak;
import com.duokan.reader.ui.welcome.DkTipManager.UserInput;
import com.duokan.reader.ui.welcome.p;

public class mx extends ActivatedController implements ak {
    private final sh a;
    private final wl b;
    private final NavigationFrameView c;
    private final FrameLayout d;
    private final nk e;
    private final et f = new et();
    private boolean g = false;
    private boolean h = true;
    private int i = 0;
    private float[] j = new float[]{0.5f, 0.1f};

    public mx(IFeature featrue, wl wlVar) {
        super(featrue);
        this.b = wlVar;
        this.a = (sh) getContext().queryFeature(sh.class);
        this.c = (NavigationFrameView) wlVar.findViewById(g.reading__reading_view__navigation_frame);
        this.d = (FrameLayout) wlVar.findViewById(g.reading__reading_view__navigation_content);
        this.f.a(false);
        this.f.a(new ag(this));
        this.c.setViewGestureDetector(this.f);
        this.c.setSizeChangedListener(new my(this));
        this.e = new nk(getContext(), this.a, new mz(this));
        this.d.addView(this.e, 0, new LayoutParams(-1, -1));
        setContentView(this.c);
    }

    public boolean a() {
        return this.g;
    }

    public void b() {
        if (!this.g) {
            f();
            a(true);
            ((p) getContext().queryFeature(p.class)).a(getContext(), UserInput.SHOW_BOOK_NAVIGATION);
        }
    }

    public void c() {
        if (this.g) {
            f();
            a(false);
        }
    }

    public void d() {
        this.e.b();
    }

    protected boolean onBack() {
        if (!a()) {
            return super.onBack();
        }
        c();
        return true;
    }

    public boolean e() {
        return this.g;
    }

    public void f() {
        if (!(this.a.b(1) || this.a.b(2))) {
            this.a.a(1, 0);
        }
        if (this.g) {
            this.a.aN();
            this.i = this.e.getWidth();
            a(-this.i, -this.i, 0, 0, 0, null);
            return;
        }
        this.e.a();
        this.c.setVisibility(0);
        this.i = 0;
        a(this.i, this.i, this.e.getWidth(), this.e.getWidth(), 0, null);
    }

    public void a(float f, float f2) {
        ((p) getContext().queryFeature(p.class)).a(getContext(), UserInput.SHOW_BOOK_NAVIGATION_GESTURE);
        this.i = Math.min(this.e.getWidth(), Math.max(0, this.i + ((int) f)));
        a(-this.i, -this.i, this.e.getWidth() - this.i, this.e.getWidth() - this.i, 0, null);
    }

    public void a(boolean z) {
        Runnable ncVar = new nc(this);
        this.g = z;
        if (this.g) {
            int i = -this.i;
            int i2 = -this.e.getWidth();
            int width = this.e.getWidth() - this.i;
            a(i, i2, width, 0, Math.round(((((float) (this.e.getWidth() - this.i)) * 1.0f) / ((float) this.e.getWidth())) * 300.0f), ncVar);
            return;
        }
        int i3 = 0;
        a(-this.i, i3, this.e.getWidth() - this.i, this.e.getWidth(), Math.round(((((float) this.i) * 1.0f) / ((float) this.e.getWidth())) * 300.0f), ncVar);
    }

    public void a(er erVar, View view, PointF pointF) {
        if (this.g && pointF.x > ((float) g())) {
            c();
        }
    }

    private int g() {
        return this.c.getWidth() - this.c.getPaddingRight();
    }

    private void a(int i) {
        ng ngVar;
        int argb = Color.argb((int) ((this.j[1] + (((((float) Math.abs(i)) * 1.0f) / ((float) g())) * (this.j[0] - this.j[1]))) * 255.0f), 0, 0, 0);
        if (this.b.getForeground() instanceof ng) {
            ngVar = (ng) this.b.getForeground();
        } else {
            ngVar = new ng();
            this.b.setForeground(ngVar);
        }
        ngVar.a(i, argb);
    }

    private void a(int i, int i2, int i3, int i4, int i5, Runnable runnable) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.initialize(0, 0, 0, 0);
        alphaAnimation.setDuration((long) i5);
        alphaAnimation.setAnimationListener(new ne(this, runnable));
        Runnable nfVar = new nf(this, alphaAnimation, i, i2, i3, i4);
        if (this.c.isLayoutRequested()) {
            UTools.addAnimation(this.c, nfVar);
        } else {
            nfVar.run();
        }
    }
}

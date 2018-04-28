package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.duokan.core.ui.Scrollable.OverScrollMode;
import com.duokan.core.ui.ZoomView;
import com.duokan.core.ui.dv;

public abstract class gd extends ZoomView {
    /* renamed from: b */
    private Point f10222b;
    /* renamed from: c */
    private View f10223c;
    /* renamed from: d */
    private Runnable f10224d;
    /* renamed from: e */
    private boolean f10225e = false;
    /* renamed from: f */
    private boolean f10226f = false;

    public gd(Context context) {
        super(context);
        setClipChildren(true);
        getScrollDetector().m2041a(new gk(this));
        setThumbEnabled(false);
    }

    /* renamed from: d */
    public void mo2334d() {
    }

    /* renamed from: e */
    public void mo2335e() {
    }

    /* renamed from: f */
    public void mo2412f() {
    }

    /* renamed from: g */
    public void mo2413g() {
        m14207b(false);
    }

    /* renamed from: h */
    public void mo2414h() {
        this.f10222b = null;
        m14205a(false);
    }

    /* renamed from: i */
    public float mo2421i() {
        return Math.min(((float) getWidth()) / ((float) this.f10223c.getWidth()), ((float) getHeight()) / ((float) this.f10223c.getHeight()));
    }

    /* renamed from: j */
    public void mo2443j() {
        if (this.f10223c != null) {
            m1359b((float) (this.f10223c.getWidth() / 2), (float) (this.f10223c.getHeight() / 2), mo2421i(), 0.0f, null, null);
        }
    }

    /* renamed from: a */
    public void m14203a(View view, LayoutParams layoutParams) {
        removeAllViews();
        this.f10223c = view;
        if (this.f10223c != null) {
            View view2 = this.f10223c;
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            addView(view2, layoutParams);
            m14205a(false);
        }
    }

    /* renamed from: a */
    public void mo2411a(Runnable runnable) {
        if (this.f10223c != null) {
            dv.m1921a(this.f10223c, new ge(this, runnable));
        }
    }

    /* renamed from: a */
    public void mo2410a(int i, boolean z) {
        if (this.f10223c != null) {
            View view = this.f10223c;
            Point point = new Point(getScrollX() + (getWidth() / 2), getScrollY() + (getHeight() / 2));
            dv.m1897a(point, (View) this, view);
            dv.m1921a(view, new gf(this, z, point, getZoomFactor(), i, view));
        }
    }

    /* renamed from: k */
    public boolean mo2415k() {
        return this.f10225e;
    }

    public void setToBeQuit(boolean z) {
        this.f10226f = z;
    }

    public void setQuitRunnable(Runnable runnable) {
        this.f10224d = runnable;
    }

    protected float getContentStaticScale() {
        return mo2421i();
    }

    protected Point getContentStaticCenter() {
        Point point = new Point(0, 0);
        if (this.f10223c != null) {
            point.set(this.f10223c.getWidth() / 2, this.f10223c.getHeight() / 2);
        }
        return point;
    }

    /* renamed from: a */
    protected boolean mo2441a(PointF pointF) {
        if (Float.compare(mo2421i(), getZoomFactor()) != 0) {
            mo2443j();
        } else if (this.f10224d != null) {
            this.f10224d.run();
        }
        return true;
    }

    /* renamed from: a */
    protected void m14205a(boolean z) {
        dv.m1921a(this.f10223c, new gh(this, z));
    }

    /* renamed from: b */
    protected void m14207b(boolean z) {
        if (this.f10223c != null) {
            Point point = new Point(0, 0);
            dv.m1945c(point, this.f10223c);
            dv.m1921a((View) this, new gi(this, z, point));
        }
    }

    private void setPullingDown(boolean z) {
        this.f10225e = z;
        if (this.f10225e) {
            setHorizontalOverScrollMode(OverScrollMode.AUTO);
            setVerticalOverScrollMode(OverScrollMode.AUTO);
        }
    }
}

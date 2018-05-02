package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.view.View;

import com.duokan.core.ui.UTools;
import com.duokan.core.ui.ZoomView;

public abstract class fy extends ZoomView {
    private Point b;
    private View c;
    private Runnable d;
    private boolean e = false;
    private boolean f = false;

    public fy(Context context) {
        super(context);
        setClipChildren(true);
        getScrollDetector().a(new gf(this));
        setThumbEnabled(false);
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
        b(false);
    }

    public void h() {
        this.b = null;
        a(false);
    }

    public float i() {
        return Math.min(((float) getWidth()) / ((float) this.c.getWidth()), ((float) getHeight()) / ((float) this.c.getHeight()));
    }

    public void j() {
        if (this.c != null) {
            b((float) (this.c.getWidth() / 2), (float) (this.c.getHeight() / 2), i(), 0.0f, null, null);
        }
    }

    public void a(View view, LayoutParams layoutParams) {
        removeAllViews();
        this.c = view;
        if (this.c != null) {
            View view2 = this.c;
            if (layoutParams == null) {
                layoutParams = new LayoutParams(-1, -1);
            }
            addView(view2, layoutParams);
            a(false);
        }
    }

    public void a(Runnable runnable) {
        if (this.c != null) {
            UTools.creatCallTask(this.c, new fz(this, runnable));
        }
    }

    public void a(int i, boolean z) {
        if (this.c != null) {
            View view = this.c;
            Point point = new Point(getScrollX() + (getWidth() / 2), getScrollY() + (getHeight() / 2));
            UTools.getTouchPoint(point, (View) this, view);
            UTools.creatCallTask(view, new ga(this, z, point, getZoomFactor(), i, view));
        }
    }

    public boolean k() {
        return this.e;
    }

    public void setToBeQuit(boolean z) {
        this.f = z;
    }

    public void setQuitRunnable(Runnable runnable) {
        this.d = runnable;
    }

    protected float getContentStaticScale() {
        return i();
    }

    protected Point getContentStaticCenter() {
        Point point = new Point(0, 0);
        if (this.c != null) {
            point.set(this.c.getWidth() / 2, this.c.getHeight() / 2);
        }
        return point;
    }

    protected boolean a(PointF pointF) {
        if (Float.compare(i(), getZoomFactor()) != 0) {
            j();
        } else if (this.d != null) {
            this.d.run();
        }
        return true;
    }

    protected void a(boolean z) {
        UTools.creatCallTask(this.c, new gc(this, z));
    }

    protected void b(boolean z) {
        if (this.c != null) {
            Point point = new Point(0, 0);
            UTools.showAnimation(point, this.c);
            UTools.creatCallTask((View) this, new gd(this, z, point));
        }
    }

    private void setPullingDown(boolean z) {
        this.e = z;
        if (this.e) {
            setHorizontalOverScrollMode(OverScrollMode.AUTO);
            setVerticalOverScrollMode(OverScrollMode.AUTO);
        }
    }
}

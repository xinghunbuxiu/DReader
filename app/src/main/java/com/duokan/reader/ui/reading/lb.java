package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.app.BaseActivity;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.app.s;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.ui.UTools;
import com.duokan.core.ui.di;
import com.duokan.core.ui.dl;
import com.duokan.core.ui.dn;
import com.duokan.core.ui.et;
import com.duokan.core.ui.ge;
import com.duokan.reader.DkApp;

import org.apache.http.HttpStatus;

import java.util.Iterator;
import java.util.LinkedList;

do;

public abstract class lb extends di implements la {
    private final sh b;
    private final lo c;
    private final et d = new et();
    private final s e;
    private final LinkedList f = new LinkedList();
    private float g = 1.0f;
    private fu h = null;

    protected abstract void b(fu fuVar);

    protected abstract void d();

    public lb(Context context) {
        super(context);
        this.b = (sh) MyContextWrapper.getFeature(context).queryFeature(sh.class);
        this.c = new lo(this, getContext());
        addView(this.c, getChildCount(), new dn(-1, -1, 17));
        this.d.a(new lj(this));
        this.e = i();
    }

    public void d(fu fuVar) {
        d();
    }

    public void c(fu fuVar) {
        if (this.h == null && this.f.contains(fuVar)) {
            f(fuVar);
            k();
        }
    }

    public void e() {
        this.c.b();
        this.h = null;
        while (!this.f.isEmpty()) {
            removeView((View) this.f.pollFirst());
        }
    }

    public void e(fu fuVar) {
        this.f.add(fuVar);
        fuVar.setImageBrowser(this);
        Rect originBounds = fuVar.getOriginBounds();
        addView(fuVar, getChildCount(), new dn(originBounds.width(), originBounds.height(), 51));
        a((View) fuVar, new dl(1.0f, originBounds.left, originBounds.top, fuVar.getImage().i(), fuVar.getImage().g(), fuVar.getImage().h()));
    }

    protected fu getActiveImageView() {
        return this.h;
    }

    protected dl a(fu fuVar) {
        Rect originBounds = getActiveImageView().getOriginBounds();
        return new dl(1.0f, originBounds.left, originBounds.top, fuVar.getImage().i(), fuVar.getImage().g(), fuVar.getImage().h());
    }

    protected void b() {
        setEnabled(false);
        if (this.h != null) {
            this.h.i();
            this.h.setZoomListener(g());
        }
        ((BaseActivity) DkApp.get().getTopActivity()).addOnScreenRotationChangedListener(this.e);
    }

    protected void c() {
        setEnabled(true);
        if (this.h != null) {
            this.h.j();
            this.h = null;
        }
        this.g = 1.0f;
    }

    protected void f(fu fuVar) {
        if (this.h == null) {
            this.h = fuVar;
            bringChildToFront(this.c);
            bringChildToFront(fuVar);
            fuVar.a(null);
            fuVar.f();
            fuVar.getPagePresenter().b();
            this.b.a((View) this);
        }
    }

    protected void f() {
        if (this.h != null) {
            View view = this.h;
            view.h();
            view.setZoomListener(null);
            ((BaseActivity) DkApp.get().getTopActivity()).removeOnScreenRotationChangedListener(this.e);
            this.c.d();
            this.b.a(null);
            Runnable lcVar = new lc(this, view);
            if (Float.compare(0.0f, b(view).l()) != 0) {
                a(0, false);
                UTools.addAnimation(view, new lf(this, lcVar));
                return;
            }
            TaskHandler.PostTask(lcVar);
        }
    }

    protected ge g() {
        return new lg(this);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        Object obj = (a(motionEvent) || this.h != null) ? 1 : null;
        return obj != null ? this.d.onTouch(this, motionEvent) : super.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (a(motionEvent) || this.h != null) {
            this.d.onTouch(this, motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.d.a((View) this);
    }

    private boolean a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            fu fuVar = (fu) it.next();
            if (fuVar.getOriginBounds().contains(x, y) && fuVar.c() && fuVar.a()) {
                return true;
            }
        }
        return false;
    }

    private s i() {
        return new lh(this);
    }

    private void a(int i, boolean z) {
        View activeImageView = getActiveImageView();
        do b = b(activeImageView);
        do doVar = new do (b);
        doVar.d((float) i);
        activeImageView.a((int) ((b.l() + activeImageView.getZoomAngle()) - doVar.l()), z);
        a(activeImageView, doVar);
    }

    private void j() {
        if (this.c.a()) {
            k();
        } else {
            f();
        }
    }

    private void k() {
        WebLog.c().b(this.h != null);
        this.c.c();
        Rect originBounds = this.h.getOriginBounds();
        float min = Math.min((((float) getWidth()) * 1.0f) / ((float) originBounds.width()), (((float) getHeight()) * 1.0f) / ((float) originBounds.height()));
        Point h = h();
        dl dlVar = new dl(1.0f, h.x - (originBounds.width() / 2), h.y - (originBounds.height() / 2), 0.0f, min, min);
        Runnable liVar = new li(this);
        this.h.g();
        if (this.h.b()) {
            a(this.h, dlVar, HttpStatus.SC_MULTIPLE_CHOICES, liVar, null);
        } else {
            liVar.run();
        }
    }

    private void a(PointF pointF, float f, float f2) {
        WebLog.c().b(this.h != null);
        Rect originBounds = this.h.getOriginBounds();
        a(this.h, new dl(1.0f, Math.round(((float) originBounds.left) + pointF.x), Math.round(((float) originBounds.top) + pointF.y), f, f2, f2));
        float f3 = this.g;
        if (((double) f2) > 1.1d * ((double) f3)) {
            this.c.c();
            this.g = f2;
        } else if (((double) f2) < 0.9d * ((double) f3)) {
            if (Float.compare(1.0f, f2) >= 0) {
                this.c.d();
            }
            this.g = f2;
        }
    }

    protected Point h() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return UTools.closeAnimation(new Point(displayMetrics.widthPixels / 2, displayMetrics.heightPixels / 2), (View) this);
    }
}

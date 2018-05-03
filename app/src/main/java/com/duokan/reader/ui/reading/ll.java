package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.app.IScreenRotationChangedListener;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.C0380do;
import com.duokan.core.ui.di;
import com.duokan.core.ui.dl;
import com.duokan.core.ui.dn;
import com.duokan.core.ui.AnimUtils;
import com.duokan.core.ui.et;
import com.duokan.core.ui.ge;
import com.duokan.reader.DkApp;
import java.util.Iterator;
import java.util.LinkedList;
import org.apache.http.HttpStatus;

public abstract class ll extends di implements lk {
    /* renamed from: b */
    private final su f10250b;
    /* renamed from: c */
    private final ly f10251c;
    /* renamed from: d */
    private final et f10252d = new et();
    /* renamed from: e */
    private final IScreenRotationChangedListener f10253e;
    /* renamed from: f */
    private final LinkedList<fz> f10254f = new LinkedList();
    /* renamed from: g */
    private float f10255g = 1.0f;
    /* renamed from: h */
    private fz f10256h = null;

    /* renamed from: b */
    protected abstract void mo2341b(fz fzVar);

    /* renamed from: d */
    protected abstract void mo2343d();

    public ll(Context context) {
        super(context);
        this.f10250b = (su) AppContext.getAppContext(context).queryFeature(su.class);
        this.f10251c = new ly(this, getContext());
        addView(this.f10251c, getChildCount(), new dn(-1, -1, 17));
        this.f10252d.m2041a(new lt(this));
        this.f10253e = m14238i();
    }

    /* renamed from: d */
    public void mo2337d(fz fzVar) {
        mo2343d();
    }

    /* renamed from: c */
    public void mo2336c(fz fzVar) {
        if (this.f10256h == null && this.f10254f.contains(fzVar)) {
            m14251f(fzVar);
            m14240k();
        }
    }

    /* renamed from: e */
    public void m14248e() {
        this.f10251c.m14628b();
        this.f10256h = null;
        while (!this.f10254f.isEmpty()) {
            removeView((View) this.f10254f.pollFirst());
        }
    }

    /* renamed from: e */
    public void m14249e(fz fzVar) {
        this.f10254f.add(fzVar);
        fzVar.setImageBrowser(this);
        Rect originBounds = fzVar.getOriginBounds();
        addView(fzVar, getChildCount(), new dn(originBounds.width(), originBounds.height(), 51));
        m1830a((View) fzVar, new dl(1.0f, originBounds.left, originBounds.top, fzVar.getImage().mo1394i(), fzVar.getImage().mo1392g(), fzVar.getImage().mo1393h()));
    }

    protected fz getActiveImageView() {
        return this.f10256h;
    }

    /* renamed from: a */
    protected dl mo2339a(fz fzVar) {
        Rect originBounds = getActiveImageView().getOriginBounds();
        return new dl(1.0f, originBounds.left, originBounds.top, fzVar.getImage().mo1394i(), fzVar.getImage().mo1392g(), fzVar.getImage().mo1393h());
    }

    /* renamed from: b */
    protected void mo2340b() {
        setEnabled(false);
        if (this.f10256h != null) {
            this.f10256h.m14176i();
            this.f10256h.setZoomListener(m14252g());
        }
        ((BaseActivity) DkApp.get().getTopActivity()).addOnScreenRotationChangedListener(this.f10253e);
    }

    /* renamed from: c */
    protected void mo2342c() {
        setEnabled(true);
        if (this.f10256h != null) {
            this.f10256h.m14177j();
            this.f10256h = null;
        }
        this.f10255g = 1.0f;
    }

    /* renamed from: f */
    protected void m14251f(fz fzVar) {
        if (this.f10256h == null) {
            this.f10256h = fzVar;
            bringChildToFront(this.f10251c);
            bringChildToFront(fzVar);
            fzVar.mo2436a(null);
            fzVar.m14173f();
            fzVar.getPagePresenter().mo1764b();
            this.f10250b.mo2019a((View) this);
        }
    }

    /* renamed from: f */
    protected void m14250f() {
        if (this.f10256h != null) {
            View view = this.f10256h;
            view.m14175h();
            view.setZoomListener(null);
            ((BaseActivity) DkApp.get().getTopActivity()).removeOnScreenRotationChangedListener(this.f10253e);
            this.f10251c.m14630d();
            this.f10250b.mo2019a(null);
            Runnable lmVar = new lm(this, view);
            if (Float.compare(0.0f, m1836b(view).m1865l()) != 0) {
                m14228a(0, false);
                AnimUtils.m1921a(view, new lp(this, lmVar));
                return;
            }
            UThread.post(lmVar);
        }
    }

    /* renamed from: g */
    protected ge m14252g() {
        return new lq(this);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return super.onTouchEvent(motionEvent);
        }
        Object obj = (m14232a(motionEvent) || this.f10256h != null) ? 1 : null;
        return obj != null ? this.f10252d.onTouch(this, motionEvent) : super.onTouchEvent(motionEvent);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (m14232a(motionEvent) || this.f10256h != null) {
            this.f10252d.onTouch(this, motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        super.requestDisallowInterceptTouchEvent(z);
        this.f10252d.m2040a((View) this);
    }

    /* renamed from: a */
    private boolean m14232a(MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Iterator it = this.f10254f.iterator();
        while (it.hasNext()) {
            fz fzVar = (fz) it.next();
            if (fzVar.getOriginBounds().contains(x, y) && fzVar.mo2469c() && fzVar.mo2467a()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: i */
    private IScreenRotationChangedListener m14238i() {
        return new lr(this);
    }

    /* renamed from: a */
    private void m14228a(int i, boolean z) {
        View activeImageView = getActiveImageView();
        C0380do b = m1836b(activeImageView);
        C0380do c0380do = new C0380do(b);
        c0380do.m1858d((float) i);
        activeImageView.mo2435a((int) ((b.m1865l() + activeImageView.getZoomAngle()) - c0380do.m1865l()), z);
        m1835a(activeImageView, c0380do);
    }

    /* renamed from: j */
    private void m14239j() {
        if (this.f10251c.m14627a()) {
            m14240k();
        } else {
            m14250f();
        }
    }

    /* renamed from: k */
    private void m14240k() {
        WebLog.init().w(this.f10256h != null);
        this.f10251c.m14629c();
        Rect originBounds = this.f10256h.getOriginBounds();
        float min = Math.min((((float) getWidth()) * 1.0f) / ((float) originBounds.width()), (((float) getHeight()) * 1.0f) / ((float) originBounds.height()));
        Point h = m14253h();
        dl dlVar = new dl(1.0f, h.x - (originBounds.width() / 2), h.y - (originBounds.height() / 2), 0.0f, min, min);
        Runnable lsVar = new ls(this);
        this.f10256h.m14174g();
        if (this.f10256h.mo2468b()) {
            m1832a(this.f10256h, dlVar, HttpStatus.SC_MULTIPLE_CHOICES, lsVar, null);
        } else {
            lsVar.run();
        }
    }

    /* renamed from: a */
    private void m14229a(PointF pointF, float f, float f2) {
        WebLog.init().w(this.f10256h != null);
        Rect originBounds = this.f10256h.getOriginBounds();
        m1830a(this.f10256h, new dl(1.0f, Math.round(((float) originBounds.left) + pointF.x), Math.round(((float) originBounds.top) + pointF.y), f, f2, f2));
        float f3 = this.f10255g;
        if (((double) f2) > 1.1d * ((double) f3)) {
            this.f10251c.m14629c();
            this.f10255g = f2;
        } else if (((double) f2) < 0.9d * ((double) f3)) {
            if (Float.compare(1.0f, f2) >= 0) {
                this.f10251c.m14630d();
            }
            this.f10255g = f2;
        }
    }

    /* renamed from: h */
    protected Point m14253h() {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return AnimUtils.m1934b(new Point(displayMetrics.widthPixels / 2, displayMetrics.heightPixels / 2), (View) this);
    }
}

package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.view.View;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.BaseActivity;
import com.duokan.core.ui.dl;
import com.duokan.core.ui.dn;
import com.duokan.reader.DkApp;

public class gn extends ll {
    /* renamed from: b */
    private boolean f10257b = false;
    /* renamed from: c */
    private final su f10258c;
    /* renamed from: d */
    private final to f10259d = m14255i();

    public gn(Context context) {
        super(context);
        this.f10258c = (su) AppContext.getAppContext(context).queryFeature(su.class);
        setClipChildren(false);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f10258c.mo2033a(this.f10259d);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f10258c.mo2102b(this.f10259d);
    }

    /* renamed from: b */
    protected void mo2340b() {
        super.mo2340b();
        this.f10257b = true;
        View activeImageView = getActiveImageView();
        this.f10258c.mo2040a(32, 0);
        this.f10258c.aQ();
        ((BaseActivity) DkApp.get().getTopActivity()).lockCurrentOrientation();
        activeImageView.setLayoutParams(new dn(-1, -1, 17, 0, m14253h().y - (getHeight() / 2)));
        m1830a(activeImageView, new dl());
    }

    /* renamed from: c */
    protected void mo2342c() {
        if (this.f10257b) {
            this.f10257b = false;
            fz activeImageView = getActiveImageView();
            Rect originBounds = activeImageView.getOriginBounds();
            activeImageView.setLayoutParams(new dn(originBounds.width(), originBounds.height(), 51));
            m1830a((View) activeImageView, mo2339a(activeImageView));
            this.f10258c.aR();
            ((BaseActivity) DkApp.get().getTopActivity()).unlockCurrentOrientation();
        }
        super.mo2342c();
    }

    /* renamed from: a */
    protected dl mo2339a(fz fzVar) {
        Rect originBounds = getActiveImageView().getOriginBounds();
        dl a = super.mo2339a(fzVar);
        if (!this.f10257b) {
            return a;
        }
        Point h = m14253h();
        float max = Math.max((((float) originBounds.width()) * 1.0f) / ((float) getWidth()), (((float) originBounds.height()) * 1.0f) / ((float) getHeight()));
        return new dl(1.0f, originBounds.centerX() - h.x, originBounds.centerY() - h.y, a.m1865l(), a.m1866m() * max, a.m1866m() * max);
    }

    /* renamed from: d */
    protected void mo2343d() {
        this.f10258c.mo2040a(0, 32);
    }

    /* renamed from: b */
    protected void mo2341b(fz fzVar) {
        this.f10258c.mo2023a(fzVar.getImage(), fzVar.getOriginBounds());
    }

    /* renamed from: i */
    private to m14255i() {
        return new go(this);
    }
}

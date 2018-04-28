package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.reader.domain.bookshelf.hb;
import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;
import com.duokan.reader.ui.general.PagesView;

public class pf extends wy {
    /* renamed from: n */
    private fs f10776n = null;
    /* renamed from: o */
    private fm f10777o = null;
    /* renamed from: p */
    private PagesView f10778p = null;

    public pf(Context context, xo xoVar) {
        super(context, xoVar);
    }

    /* renamed from: b */
    public void mo2465b() {
        this.f10777o.setVisibility(4);
        this.f10776n.setVisibility(0);
        this.f10778p = this.f10776n;
    }

    /* renamed from: c */
    public void mo2466c() {
        this.f10777o.setVisibility(0);
        this.f10776n.setVisibility(8);
        this.c.setVisibility(4);
        this.f10778p = this.f10777o;
    }

    public void setPageContentMargins(RectF[] rectFArr) {
        this.f10777o.setContentMargins(rectFArr);
    }

    public PageScaleType getPageScaleType() {
        return this.f10777o.getPageScaleType();
    }

    public void setPageScaleType(PageScaleType pageScaleType) {
        this.f10777o.setPageScaleType(pageScaleType);
    }

    /* renamed from: a */
    public void m14896a(int i, int i2, float f) {
        this.f10777o.m9989a(i, i2, f);
    }

    public float getZoomFactor() {
        return this.f10777o.getZoomFactor();
    }

    public Rect getCurrentPageVisiableRect() {
        return this.f10777o.getCurrentPagePresenter().mo1762a();
    }

    public PagesView getShowingPagesView() {
        return this.f10778p;
    }

    public hd getShowingDocPresenter() {
        return (hd) this.f10778p;
    }

    /* renamed from: a */
    public void mo2257a() {
        this.f10776n = new fs(getContext());
        this.f10777o = new fm(getContext());
        this.f10777o.setClipToContent(true);
        this.b.addView(this.f10776n, new LayoutParams(-1, -1));
        this.b.addView(this.f10777o, new LayoutParams(-1, -1));
        this.f10776n.setVisibility(4);
        hb b = this.a.mo1992G().m4152E().m4819b();
        setPageContentMargins(b.m4623d());
        setPageScaleType(b.m4624e());
        m14896a(0, 0, b.m4622c());
        if (this.a.mo2145g()) {
            mo2466c();
        } else {
            mo2465b();
        }
    }

    protected fm getFixedPagesView() {
        return this.f10777o;
    }

    protected fs getFlowPagesView() {
        return this.f10776n;
    }
}

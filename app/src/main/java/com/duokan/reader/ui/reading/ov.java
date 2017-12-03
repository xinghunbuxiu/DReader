package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;

import com.duokan.reader.domain.bookshelf.hh;
import com.duokan.reader.ui.general.FixedPagesView.PageScaleType;
import com.duokan.reader.ui.general.PagesView;

public class ov extends wl {
    private fo n = null;
    private fi o = null;
    private PagesView p = null;

    public ov(Context context, xb xbVar) {
        super(context, xbVar);
    }

    public void b() {
        this.o.setVisibility(4);
        this.n.setVisibility(0);
        this.p = this.n;
    }

    public void c() {
        this.o.setVisibility(0);
        this.n.setVisibility(8);
        this.c.setVisibility(4);
        this.p = this.o;
    }

    public void setPageContentMargins(RectF[] rectFArr) {
        this.o.setContentMargins(rectFArr);
    }

    public PageScaleType getPageScaleType() {
        return this.o.getPageScaleType();
    }

    public void setPageScaleType(PageScaleType pageScaleType) {
        this.o.setPageScaleType(pageScaleType);
    }

    public void a(int i, int i2, float f) {
        this.o.a(i, i2, f);
    }

    public float getZoomFactor() {
        return this.o.getZoomFactor();
    }

    public Rect getCurrentPageVisiableRect() {
        return this.o.getCurrentPagePresenter().a();
    }

    public PagesView getShowingPagesView() {
        return this.p;
    }

    public gy getShowingDocPresenter() {
        return (gy) this.p;
    }

    public void a() {
        this.n = new fo(getContext());
        this.o = new fi(getContext());
        this.o.setClipToContent(true);
        this.b.addView(this.n, new LayoutParams(-1, -1));
        this.b.addView(this.o, new LayoutParams(-1, -1));
        this.n.setVisibility(4);
        hh b = this.a.G().D().b();
        setPageContentMargins(b.d());
        setPageScaleType(b.e());
        a(0, 0, b.c());
        if (this.a.g()) {
            c();
        } else {
            b();
        }
    }

    protected fi getFixedPagesView() {
        return this.o;
    }

    protected fo getFlowPagesView() {
        return this.n;
    }
}

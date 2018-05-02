package com.duokan.reader.ui.reading;

import android.content.Context;

import com.duokan.reader.ui.general.PagesView;

public class afb extends wl {
    private fo n = null;

    public afb(Context context, xb xbVar) {
        super(context, xbVar);
    }

    protected fi getFixedPagesView() {
        return null;
    }

    protected fo getFlowPagesView() {
        return this.n;
    }

    public PagesView getShowingPagesView() {
        return this.n;
    }

    public gy getShowingDocPresenter() {
        return this.n;
    }

    public void a() {
        this.n = new fo(getContext());
        this.b.addView(this.n, new LayoutParams(-1, -1));
    }
}

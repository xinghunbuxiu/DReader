package com.duokan.reader.ui.reading;

import android.content.Context;

import com.duokan.reader.ui.general.PagesView;

public class io extends wl {
    private ij n = null;

    public io(Context context, xb xbVar) {
        super(context, xbVar);
    }

    public int getAdShownCount() {
        return this.n.u();
    }

    public PagesView getShowingPagesView() {
        return this.n;
    }

    public gy getShowingDocPresenter() {
        return this.n;
    }

    public void a() {
        this.n = new ij(getContext());
        this.b.addView(this.n, new LayoutParams(-1, -1));
    }

    protected fi getFixedPagesView() {
        return null;
    }

    protected fo getFlowPagesView() {
        return this.n;
    }
}

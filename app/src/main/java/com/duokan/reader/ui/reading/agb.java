package com.duokan.reader.ui.reading;

import android.content.Context;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.reader.ui.general.PagesView;

public class agb extends wy {
    /* renamed from: n */
    private fs f9711n = null;

    public agb(Context context, xo xoVar) {
        super(context, xoVar);
    }

    protected fm getFixedPagesView() {
        return null;
    }

    protected fs getFlowPagesView() {
        return this.f9711n;
    }

    public PagesView getShowingPagesView() {
        return this.f9711n;
    }

    public hd getShowingDocPresenter() {
        return this.f9711n;
    }

    /* renamed from: a */
    public void mo2257a() {
        this.f9711n = new fs(getContext());
        this.b.addView(this.f9711n, new LayoutParams(-1, -1));
    }
}

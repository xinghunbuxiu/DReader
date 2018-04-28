package com.duokan.reader.ui.reading;

import android.content.Context;
import android.widget.FrameLayout.LayoutParams;
import com.duokan.reader.ui.general.PagesView;

public class iy extends wy {
    /* renamed from: n */
    private it f10413n = null;

    public iy(Context context, xo xoVar) {
        super(context, xoVar);
    }

    public int getAdShownCount() {
        return this.f10413n.m14452u();
    }

    public PagesView getShowingPagesView() {
        return this.f10413n;
    }

    public hd getShowingDocPresenter() {
        return this.f10413n;
    }

    /* renamed from: a */
    public void mo2257a() {
        this.f10413n = new it(getContext());
        this.b.addView(this.f10413n, new LayoutParams(-1, -1));
    }

    protected fm getFixedPagesView() {
        return null;
    }

    protected fs getFlowPagesView() {
        return this.f10413n;
    }
}

package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.View;

import com.duokan.core.app.x;
import com.duokan.reader.domain.document.a;
import com.duokan.reader.ui.general.PagesView.PageLayout;

class xt extends fo {
    private final sh a = ((sh) x.a(getContext()).queryFeature(sh.class));
    private View b = null;
    private int c = -1;
    private boolean d = true;

    protected /* synthetic */ fs b(a aVar) {
        return c(aVar);
    }

    public xt(Context context) {
        super(context);
        setAdapter(new xx());
    }

    protected xw c(a aVar) {
        return new xw(this, aVar);
    }

    public void setPageLayout(PageLayout pageLayout) {
        if (getPageLayout() != pageLayout) {
            setZoomEnabled(pageLayout == PageLayout.TOP_TO_BOTTOM);
            setZoomFactor(1.0f);
            super.setPageLayout(pageLayout);
        }
    }

    public void a(a aVar) {
        this.d = true;
        super.a(aVar);
    }
}

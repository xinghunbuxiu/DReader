package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.View;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.domain.document.Document_a;

class xt extends fo {
    private final sh a = ((sh) MyContextWrapper.getFeature(getContext()).queryFeature(sh.class));
    private View b = null;
    private int c = -1;
    private boolean d = true;

    protected /* synthetic */ fs b(Document_a aVar) {
        return c(aVar);
    }

    public xt(Context context) {
        super(context);
        setAdapter(new xx());
    }

    protected xw c(Document_a aVar) {
        return new xw(this, aVar);
    }

    public void setPageLayout(PageLayout pageLayout) {
        if (getPageLayout() != pageLayout) {
            setZoomEnabled(pageLayout == PageLayout.TOP_TO_BOTTOM);
            setZoomFactor(1.0f);
            super.setPageLayout(pageLayout);
        }
    }

    public void a(Document_a aVar) {
        this.d = true;
        super.a(aVar);
    }
}

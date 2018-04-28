package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.View;
import com.duokan.core.app.AppContext;
import com.duokan.reader.domain.document.C0896a;

class yg extends fs {
    /* renamed from: a */
    private final su f11188a = ((su) AppContext.getAppContext(getContext()).queryFeature(su.class));
    /* renamed from: b */
    private View f11189b = null;
    /* renamed from: c */
    private int f11190c = -1;
    /* renamed from: d */
    private boolean f11191d = true;

    /* renamed from: b */
    protected /* synthetic */ fx mo2517b(C0896a c0896a) {
        return m15162c(c0896a);
    }

    public yg(Context context) {
        super(context);
        setAdapter(new yk());
    }

    /* renamed from: c */
    protected yj m15162c(C0896a c0896a) {
        return new yj(this, c0896a);
    }

    public void setPageLayout(PageLayout pageLayout) {
        if (getPageLayout() != pageLayout) {
            setZoomEnabled(pageLayout == PageLayout.TOP_TO_BOTTOM);
            setZoomFactor(1.0f);
            super.setPageLayout(pageLayout);
        }
    }

    /* renamed from: a */
    public void mo1984a(C0896a c0896a) {
        this.f11191d = true;
        super.mo1984a(c0896a);
    }
}

package com.duokan.reader.ui.general;

import com.duokan.core.app.AppContext;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.C0457r;

class ai implements C0457r {
    /* renamed from: a */
    final /* synthetic */ ah f6932a;

    ai(ah ahVar) {
        this.f6932a = ahVar;
    }

    public int getPageHeaderHeight() {
        C0435s c0435s = (C0435s) AppContext.getAppContext(this.f6932a.f6930a).queryFeature(C0435s.class);
        if (c0435s == null) {
            return 0;
        }
        return c0435s.getTheme().getPageHeaderHeight();
    }

    public int getPageHeaderPaddingTop() {
        C0435s c0435s = (C0435s) AppContext.getAppContext(this.f6932a.f6930a).queryFeature(C0435s.class);
        if (c0435s == null) {
            return 0;
        }
        return c0435s.getTheme().getPageHeaderPaddingTop();
    }

    public int getHeaderPaddingTop() {
        if (ReaderEnv.get().forHd()) {
            return 0;
        }
        C0435s c0435s = (C0435s) AppContext.getAppContext(this.f6932a.f6930a).queryFeature(C0435s.class);
        if (c0435s == null) {
            return 0;
        }
        return c0435s.getTheme().getHeaderPaddingTop();
    }

    public int getPagePaddingBottom() {
        C0435s c0435s = (C0435s) AppContext.getAppContext(this.f6932a.f6930a).queryFeature(C0435s.class);
        if (c0435s == null) {
            return 0;
        }
        return c0435s.getTheme().getPagePaddingBottom();
    }
}

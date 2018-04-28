package com.duokan.reader.ui.general;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;

class ft implements cg {
    /* renamed from: a */
    final /* synthetic */ PagesView f7257a;

    ft(PagesView pagesView) {
        this.f7257a = pagesView;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        this.f7257a.m9994a(scrollState, scrollState2);
        if (this.f7257a.f6831k != null) {
            this.f7257a.f6831k.mo478a(scrollable, scrollState, scrollState2);
        }
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
        this.f7257a.mo1736a(z);
        if (this.f7257a.f6831k != null) {
            this.f7257a.f6831k.mo479a(scrollable, z);
        }
    }
}

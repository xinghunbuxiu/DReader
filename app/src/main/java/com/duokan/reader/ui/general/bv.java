package com.duokan.reader.ui.general;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;

class bv implements cg {
    /* renamed from: a */
    final /* synthetic */ DotScrollerView f7010a;

    bv(DotScrollerView dotScrollerView) {
        this.f7010a = dotScrollerView;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (this.f7010a.f6819c != null) {
            this.f7010a.f6819c.mo478a(scrollable, scrollState, scrollState2);
        }
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
        this.f7010a.m9974a();
        if (this.f7010a.f6819c != null) {
            this.f7010a.f6819c.mo479a(scrollable, z);
        }
    }
}

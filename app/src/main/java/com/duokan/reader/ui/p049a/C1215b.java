package com.duokan.reader.ui.p049a;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;
import com.duokan.core.ui.AnimUtils;

/* renamed from: com.duokan.reader.ui.a.b */
class C1215b implements cg {
    /* renamed from: a */
    final /* synthetic */ C1214a f5708a;

    C1215b(C1214a c1214a) {
        this.f5708a = c1214a;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.DRAG) {
            AnimUtils.m1909a(this.f5708a.getContext());
        }
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
    }
}

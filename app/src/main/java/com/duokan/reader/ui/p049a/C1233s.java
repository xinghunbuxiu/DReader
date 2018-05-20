package com.duokan.reader.ui.p049a;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.OnScrollListener;
import com.duokan.core.ui.AnimUtils;

/* renamed from: com.duokan.reader.ui.a.s */
class C1233s implements OnScrollListener {
    /* renamed from: a */
    final /* synthetic */ C1228n f5736a;

    C1233s(C1228n c1228n) {
        this.f5736a = c1228n;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.DRAG || scrollState2 == ScrollState.FLING) {
            AnimUtils.m1909a(this.f5736a.getContext());
        }
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
    }
}

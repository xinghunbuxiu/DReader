package com.duokan.reader.ui.reading;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.OnScrollListener;

class nc implements OnScrollListener {
    /* renamed from: a */
    final /* synthetic */ nb f10659a;

    nc(nb nbVar) {
        this.f10659a = nbVar;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        this.f10659a.f10655a.invalidate();
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
        this.f10659a.f10655a.invalidate();
    }
}

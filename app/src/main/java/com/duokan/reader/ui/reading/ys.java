package com.duokan.reader.ui.reading;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.OnScrollListener;
import com.duokan.reader.ui.general.ReaderUi;

class ys implements OnScrollListener {
    /* renamed from: a */
    final /* synthetic */ yo f11216a;

    ys(yo yoVar) {
        this.f11216a = yoVar;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.DRAG) {
            ReaderUi.m10161a(this.f11216a.getContext(), this.f11216a.f11203c);
        }
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
    }
}

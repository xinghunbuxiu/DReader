package com.duokan.reader.ui.reading;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;
import com.duokan.reader.ui.general.ReaderUi;

class yf implements cg {
    final /* synthetic */ yb a;

    yf(yb ybVar) {
        this.a = ybVar;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.DRAG) {
            ReaderUi.a(this.a.getContext(), this.a.c);
        }
    }

    public void a(Scrollable scrollable, boolean z) {
    }
}

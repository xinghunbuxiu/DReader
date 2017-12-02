package com.duokan.reader.ui.general;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;

class dy implements cg {
    final /* synthetic */ ds a;

    dy(ds dsVar) {
        this.a = dsVar;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
    }

    public void a(Scrollable scrollable, boolean z) {
        this.a.h.invalidate();
        this.a.i.invalidate();
    }
}

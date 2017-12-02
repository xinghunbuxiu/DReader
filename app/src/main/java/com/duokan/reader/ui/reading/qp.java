package com.duokan.reader.ui.reading;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;

class qp implements cg {
    final /* synthetic */ qh a;

    qp(qh qhVar) {
        this.a = qhVar;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 != ScrollState.IDLE) {
            this.a.c.a(1, 0);
        }
    }

    public void a(Scrollable scrollable, boolean z) {
    }
}

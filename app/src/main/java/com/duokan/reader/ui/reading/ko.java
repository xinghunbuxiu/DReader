package com.duokan.reader.ui.reading;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;
import com.duokan.reader.domain.statistics.C1163a;

class ko implements cg {
    /* renamed from: a */
    final /* synthetic */ kn f10522a;

    ko(kn knVar) {
        this.f10522a = knVar;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (this.f10522a.f10519g != null && scrollState2 == ScrollState.FLING && scrollable.getViewportBounds().top > 0) {
            this.f10522a.m14570d();
            C1163a.m8627k().m8657d("reading/hang-ad/" + this.f10522a.f10519g.f10533a + "/ignore");
        }
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
        if (this.f10522a.f10519g != null && scrollable.getScrollState() == ScrollState.DRAG && ((float) scrollable.getViewportBounds().top) < ((float) (-scrollable.getMaxOverScrollHeight())) * 0.9f) {
            this.f10522a.m14563a(this.f10522a.f10519g.f10538f.toString());
        }
    }
}

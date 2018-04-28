package com.duokan.core.ui;

import com.duokan.core.ui.HatGridView.HatTipState;
import com.duokan.core.ui.Scrollable.ScrollState;

class ae implements cg {
    /* renamed from: a */
    final /* synthetic */ HatGridView f896a;

    ae(HatGridView hatGridView) {
        this.f896a = hatGridView;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.IDLE) {
            if (this.f896a.f834x == HatTipState.DOCKING) {
                this.f896a.m1191a(HatTipState.DOCKED);
            } else if (this.f896a.f834x == HatTipState.UNDOCKING) {
                this.f896a.m1191a(HatTipState.UNDOCKED);
            }
        }
        if (scrollState == ScrollState.DRAG) {
            this.f896a.f835y = 0;
            if (!this.f896a.m1252b()) {
                this.f896a.m1191a(HatTipState.UNDOCKING);
            }
        }
        this.f896a.m1195a(scrollState, scrollState2);
        if (this.f896a.f808B != null) {
            this.f896a.f808B.mo478a(scrollable, scrollState, scrollState2);
        }
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
        int i = this.f896a.f811a.getViewportBounds().top;
        int height = this.f896a.f811a.getViewportBounds().bottom - this.f896a.f811a.getHeight();
        int scrollY = this.f896a.f814d.getScrollY() + this.f896a.m1229t();
        if (this.f896a.f828r || i < scrollY) {
            scrollY = Math.max(0, Math.min((-this.f896a.m1229t()) + i, (-this.f896a.m1229t()) + this.f896a.m1227s()));
            this.f896a.f814d.scrollTo(0, scrollY);
            this.f896a.f816f.scrollTo(0, (-scrollY) / 2);
            this.f896a.f815e.invalidate();
        } else {
            this.f896a.f814d.invalidate();
        }
        this.f896a.f813c.offsetTopAndBottom((((this.f896a.f811a.getPaddingTop() - this.f896a.m1209j()) + this.f896a.m1205h()) - i) - this.f896a.f813c.getTop());
        this.f896a.f812b.offsetTopAndBottom(((((this.f896a.f811a.getContentHeight() - this.f896a.f822l.bottom) - this.f896a.m1211k()) - this.f896a.m1207i()) - height) - this.f896a.f812b.getTop());
        if (this.f896a.f808B != null) {
            this.f896a.f808B.mo479a(scrollable, z);
        }
    }
}

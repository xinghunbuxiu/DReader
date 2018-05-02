package com.duokan.core.ui;

import com.duokan.core.ui.HatGridView.HatTipState;
import com.duokan.core.ui.Scrollable.ScrollState;

class ae implements OnScrollListener {
    final  HatGridView a;

    ae(HatGridView hatGridView) {
        this.a = hatGridView;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.IDLE) {
            if (this.a.x == HatTipState.DOCKING) {
                this.a.a(HatTipState.DOCKED);
            } else if (this.a.x == HatTipState.UNDOCKING) {
                this.a.a(HatTipState.UNDOCKED);
            }
        }
        if (scrollState == ScrollState.DRAG) {
            this.a.y = 0;
            if (!this.a.b()) {
                this.a.a(HatTipState.UNDOCKING);
            }
        }
        this.a.a(scrollState, scrollState2);
        if (this.a.B != null) {
            this.a.B.a(scrollable, scrollState, scrollState2);
        }
    }

    public void a(Scrollable scrollable, boolean z) {
        int i = this.a.a.getViewportBounds().top;
        int height = this.a.a.getViewportBounds().bottom - this.a.a.getHeight();
        int scrollY = this.a.d.getScrollY() + this.a.t();
        if (this.a.r || i < scrollY) {
            scrollY = Math.max(0, Math.min((-this.a.t()) + i, (-this.a.t()) + this.a.s()));
            this.a.d.scrollTo(0, scrollY);
            this.a.f.scrollTo(0, (-scrollY) / 2);
            this.a.e.invalidate();
        } else {
            this.a.d.invalidate();
        }
        this.a.c.offsetTopAndBottom((((this.a.a.getPaddingTop() - this.a.j()) + this.a.h()) - i) - this.a.c.getTop());
        this.a.b.offsetTopAndBottom(((((this.a.a.getContentHeight() - this.a.l.bottom) - this.a.k()) - this.a.i()) - height) - this.a.b.getTop());
        if (this.a.B != null) {
            this.a.B.a(scrollable, z);
        }
    }
}

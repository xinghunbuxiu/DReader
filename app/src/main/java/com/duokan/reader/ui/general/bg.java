package com.duokan.reader.ui.general;

import com.duokan.core.ui.HatGridView.HatTipState;
import com.duokan.core.ui.PullDownRefreshBaseView.RefreshState;
import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;

class bg implements cg {
    final /* synthetic */ DkWebListView a;

    bg(DkWebListView dkWebListView) {
        this.a = dkWebListView;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.IDLE) {
            if (this.a.d.f()) {
                this.a.postDelayed(new bh(this), 800);
            }
            if (!this.a.b() && this.a.a.getHatTipState() == HatTipState.DOCKED && this.a.c.getRefreshState() == RefreshState.RELEASE_TO_REFRESH) {
                this.a.c.setRefreshState(RefreshState.REFRESHING);
                this.a.postDelayed(new bi(this), 800);
            }
        }
        if (scrollState == ScrollState.DRAG && this.a.f() && this.a.a.getHatTipDockable()) {
            if (this.a.a.a()) {
                this.a.a.setHatTipDockableHeight(-1);
            }
            if (this.a.c.getRefreshState() == RefreshState.REFRESH_DONE) {
                this.a.a.setHatTipDockable(false);
            }
        }
        if (this.a.g != null) {
            this.a.g.a(scrollable, scrollState, scrollState2);
        }
    }

    public void a(Scrollable scrollable, boolean z) {
        if (scrollable.getScrollState() == ScrollState.DRAG && this.a.f() && (this.a.c.getRefreshState() == RefreshState.DOWN_TO_REFRESH || this.a.c.getRefreshState() == RefreshState.RELEASE_TO_REFRESH)) {
            HatTipState hatTipState = this.a.a.getHatTipState();
            if (hatTipState != HatTipState.DOCKING && hatTipState != HatTipState.DOCKED) {
                this.a.c.setRefreshState(RefreshState.DOWN_TO_REFRESH);
            } else if (this.a.a.a()) {
                this.a.c.setRefreshState(RefreshState.RELEASE_TO_REFRESH);
            }
        }
        this.a.c.setRate(Math.min(Math.abs(((float) this.a.a.getGridScrollY()) / ((float) this.a.c.getHeight())), 1.0f));
        if (this.a.g != null) {
            this.a.g.a(scrollable, z);
        }
    }
}

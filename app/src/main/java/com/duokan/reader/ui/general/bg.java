package com.duokan.reader.ui.general;

import com.duokan.core.ui.HatGridView.HatTipState;
import com.duokan.core.ui.PullDownRefreshBaseView.RefreshState;
import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;

class bg implements cg {
    /* renamed from: a */
    final /* synthetic */ DkWebListView f6996a;

    bg(DkWebListView dkWebListView) {
        this.f6996a = dkWebListView;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.IDLE) {
            if (this.f6996a.f6795d.m10309f()) {
                this.f6996a.postDelayed(new bh(this), 800);
            }
            if (!this.f6996a.m9963b() && this.f6996a.f6792a.getHatTipState() == HatTipState.DOCKED && this.f6996a.f6794c.getRefreshState() == RefreshState.RELEASE_TO_REFRESH) {
                this.f6996a.f6794c.setRefreshState(RefreshState.REFRESHING);
                this.f6996a.postDelayed(new bi(this), 800);
            }
        }
        if (scrollState == ScrollState.DRAG && this.f6996a.m9949f() && this.f6996a.f6792a.getHatTipDockable()) {
            if (this.f6996a.f6792a.m1248a()) {
                this.f6996a.f6792a.setHatTipDockableHeight(-1);
            }
            if (this.f6996a.f6794c.getRefreshState() == RefreshState.REFRESH_DONE) {
                this.f6996a.f6792a.setHatTipDockable(false);
            }
        }
        if (this.f6996a.f6798g != null) {
            this.f6996a.f6798g.mo478a(scrollable, scrollState, scrollState2);
        }
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
        if (scrollable.getScrollState() == ScrollState.DRAG && this.f6996a.m9949f() && (this.f6996a.f6794c.getRefreshState() == RefreshState.DOWN_TO_REFRESH || this.f6996a.f6794c.getRefreshState() == RefreshState.RELEASE_TO_REFRESH)) {
            HatTipState hatTipState = this.f6996a.f6792a.getHatTipState();
            if (hatTipState != HatTipState.DOCKING && hatTipState != HatTipState.DOCKED) {
                this.f6996a.f6794c.setRefreshState(RefreshState.DOWN_TO_REFRESH);
            } else if (this.f6996a.f6792a.m1248a()) {
                this.f6996a.f6794c.setRefreshState(RefreshState.RELEASE_TO_REFRESH);
            }
        }
        this.f6996a.f6794c.setRate(Math.min(Math.abs(((float) this.f6996a.f6792a.getGridScrollY()) / ((float) this.f6996a.f6794c.getHeight())), 1.0f));
        if (this.f6996a.f6798g != null) {
            this.f6996a.f6798g.mo479a(scrollable, z);
        }
    }
}

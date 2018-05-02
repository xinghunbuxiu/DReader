package com.duokan.reader.ui.general.web;

import com.duokan.core.ui.PullDownRefreshBaseView.RefreshState;
import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.OnScrollListener;
import com.duokan.reader.ui.general.WebView.PullDownHeaderState;

class j implements OnScrollListener {
    final /* synthetic */ DkWebView a;

    j(DkWebView dkWebView) {
        this.a = dkWebView;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.IDLE && !this.a.b() && this.a.getPullDownHeaderState() == PullDownHeaderState.DOCKED && this.a.f.getRefreshState() == RefreshState.RELEASE_TO_REFRESH) {
            this.a.f.setRefreshState(RefreshState.REFRESHING);
            this.a.postDelayed(new k(this), 800);
        }
        if (scrollState == ScrollState.DRAG && this.a.m() && super.getPullDownHeaderDockable()) {
            if (super.j()) {
                super.setPullDownHeaderDockableHeight(-1);
            }
            if (this.a.f.getRefreshState() == RefreshState.REFRESH_DONE) {
                super.setPullDownHeaderDockable(false);
            }
        }
        if (this.a.g != null) {
            this.a.g.a(scrollable, scrollState, scrollState2);
        }
    }

    public void a(Scrollable scrollable, boolean z) {
        if (scrollable.getScrollState() == ScrollState.DRAG && this.a.m() && (this.a.f.getRefreshState() == RefreshState.DOWN_TO_REFRESH || this.a.f.getRefreshState() == RefreshState.RELEASE_TO_REFRESH)) {
            PullDownHeaderState pullDownHeaderState = this.a.getPullDownHeaderState();
            if (pullDownHeaderState != PullDownHeaderState.DOCKING && pullDownHeaderState != PullDownHeaderState.DOCKED) {
                this.a.f.setRefreshState(RefreshState.DOWN_TO_REFRESH);
            } else if (this.a.j()) {
                this.a.f.setRefreshState(RefreshState.RELEASE_TO_REFRESH);
            }
        }
        this.a.f.setRate(Math.min(Math.abs(((float) this.a.getScrollY()) / ((float) this.a.f.getHeight())), 1.0f));
        if (this.a.g != null) {
            this.a.g.a(scrollable, z);
        }
    }
}

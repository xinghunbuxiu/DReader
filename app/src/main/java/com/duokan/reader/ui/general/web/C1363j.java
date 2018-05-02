package com.duokan.reader.ui.general.web;

import com.duokan.core.ui.PullDownRefreshBaseView.RefreshState;
import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;
import com.duokan.reader.ui.general.WebView.PullDownHeaderState;

/* renamed from: com.duokan.reader.ui.general.web.j */
class C1363j implements cg {
    /* renamed from: a */
    final /* synthetic */ DkWebView f8028a;

    C1363j(DkWebView dkWebView) {
        this.f8028a = dkWebView;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.IDLE && !this.f8028a.m2118b() && this.f8028a.getPullDownHeaderState() == PullDownHeaderState.DOCKED && this.f8028a.f7562f.getRefreshState() == RefreshState.RELEASE_TO_REFRESH) {
            this.f8028a.f7562f.setRefreshState(RefreshState.REFRESHING);
            this.f8028a.postDelayed(new C1364k(this), 800);
        }
        if (scrollState == ScrollState.DRAG && this.f8028a.m10981m() && super.getPullDownHeaderDockable()) {
            if (super.m10191j()) {
                super.setPullDownHeaderDockableHeight(-1);
            }
            if (this.f8028a.f7562f.getRefreshState() == RefreshState.REFRESH_DONE) {
                super.setPullDownHeaderDockable(false);
            }
        }
        if (this.f8028a.f7563g != null) {
            this.f8028a.f7563g.mo478a(scrollable, scrollState, scrollState2);
        }
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
        if (scrollable.getScrollState() == ScrollState.DRAG && this.f8028a.m10981m() && (this.f8028a.f7562f.getRefreshState() == RefreshState.DOWN_TO_REFRESH || this.f8028a.f7562f.getRefreshState() == RefreshState.RELEASE_TO_REFRESH)) {
            PullDownHeaderState pullDownHeaderState = this.f8028a.getPullDownHeaderState();
            if (pullDownHeaderState != PullDownHeaderState.DOCKING && pullDownHeaderState != PullDownHeaderState.DOCKED) {
                this.f8028a.f7562f.setRefreshState(RefreshState.DOWN_TO_REFRESH);
            } else if (this.f8028a.m10191j()) {
                this.f8028a.f7562f.setRefreshState(RefreshState.RELEASE_TO_REFRESH);
            }
        }
        this.f8028a.f7562f.setRate(Math.min(Math.abs(((float) this.f8028a.getScrollY()) / ((float) this.f8028a.f7562f.getHeight())), 1.0f));
        if (this.f8028a.f7563g != null) {
            this.f8028a.f7563g.mo479a(scrollable, z);
        }
    }
}

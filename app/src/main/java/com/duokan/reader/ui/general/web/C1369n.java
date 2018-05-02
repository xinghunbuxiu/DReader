package com.duokan.reader.ui.general.web;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.duokan.core.ui.PullDownRefreshBaseView.RefreshState;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.reader.ui.general.jg;

/* renamed from: com.duokan.reader.ui.general.web.n */
class C1369n extends jg {
    /* renamed from: d */
    final /* synthetic */ DkWebView f8169d;

    public C1369n(DkWebView dkWebView, ViewGroup viewGroup) {
        this.f8169d = dkWebView;
        super(dkWebView, viewGroup);
    }

    /* renamed from: a */
    protected void mo502a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            if (!this.f8169d.m10981m() || getScrollState() != ScrollState.IDLE) {
                this.f8169d.f7562f.setRefreshState(RefreshState.NO_REFRESH);
            } else if (this.f8169d.f7562f.getRefreshState() != RefreshState.REFRESHING) {
                if (this.f8169d.m2118b()) {
                    this.f8169d.f7562f.setRefreshState(RefreshState.NO_REFRESH);
                } else {
                    this.f8169d.f7562f.setRefreshState(RefreshState.DOWN_TO_REFRESH);
                }
            }
            if (this.f8169d.f7562f.getRefreshState() != RefreshState.NO_REFRESH) {
                super.setPullDownHeaderDockable(true);
                super.setPullDownHeaderDockableHeight(-1);
            } else {
                super.setPullDownHeaderDockable(false);
            }
        }
        super.mo502a(motionEvent);
    }
}

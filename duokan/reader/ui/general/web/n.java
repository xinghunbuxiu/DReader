package com.duokan.reader.ui.general.web;

import android.view.MotionEvent;
import android.view.ViewGroup;

import com.duokan.core.ui.PullDownRefreshBaseView.RefreshState;
import com.duokan.reader.ui.general.jw;

class n extends jw {
    final /* synthetic */ DkWebView d;

    public n(DkWebView dkWebView, ViewGroup viewGroup) {
        this.d = dkWebView;
        super(dkWebView, viewGroup);
    }

    protected void a(MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            if (!this.d.m() || getScrollState() != ScrollState.IDLE) {
                this.d.f.setRefreshState(RefreshState.NO_REFRESH);
            } else if (this.d.f.getRefreshState() != RefreshState.REFRESHING) {
                if (this.d.b()) {
                    this.d.f.setRefreshState(RefreshState.NO_REFRESH);
                } else {
                    this.d.f.setRefreshState(RefreshState.DOWN_TO_REFRESH);
                }
            }
            if (this.d.f.getRefreshState() != RefreshState.NO_REFRESH) {
                super.setPullDownHeaderDockable(true);
                super.setPullDownHeaderDockableHeight(-1);
            } else {
                super.setPullDownHeaderDockable(false);
            }
        }
        super.a(motionEvent);
    }
}

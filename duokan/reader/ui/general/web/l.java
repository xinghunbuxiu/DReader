package com.duokan.reader.ui.general.web;

import android.view.ViewGroup;

import com.duokan.core.sys.IdleStatus;

class l implements IdleStatus {
    final /* synthetic */ DkWebView a;

    l(DkWebView dkWebView) {
        this.a = dkWebView;
    }

    public boolean idleRun() {
        if (this.a.getWindowToken() == null) {
            ViewGroup viewGroup = (ViewGroup) this.a.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.a);
                this.a.removeAllViews();
            }
            this.a.f();
        }
        return false;
    }
}

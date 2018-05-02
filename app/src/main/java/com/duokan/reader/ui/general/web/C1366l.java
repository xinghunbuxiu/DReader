package com.duokan.reader.ui.general.web;

import android.view.ViewGroup;
import com.duokan.core.sys.IdleHandlerListener;

/* renamed from: com.duokan.reader.ui.general.web.l */
class C1366l implements IdleHandlerListener {
    /* renamed from: a */
    final /* synthetic */ DkWebView f8129a;

    C1366l(DkWebView dkWebView) {
        this.f8129a = dkWebView;
    }

    public boolean idleRun() {
        if (this.f8129a.getWindowToken() == null) {
            ViewGroup viewGroup = (ViewGroup) this.f8129a.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(this.f8129a);
                this.f8129a.removeAllViews();
            }
            this.f8129a.mo1821f();
        }
        return false;
    }
}

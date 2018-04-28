package com.duokan.reader.ui.reading;

import com.duokan.core.sys.IdleHandlerListener;
import com.duokan.core.ui.Scrollable.ScrollState;

class ss implements IdleHandlerListener {
    /* renamed from: a */
    final /* synthetic */ boolean f10954a;
    /* renamed from: b */
    final /* synthetic */ si f10955b;

    ss(si siVar, boolean z) {
        this.f10955b = siVar;
        this.f10954a = z;
    }

    public boolean idleRun() {
        if (this.f10955b.f9358c.f9277a != this || this.f10955b.f9358c.f9293q) {
            return false;
        }
        if (this.f10955b.f9358c.f9281e.getShowingPagesView().getScrollState() != ScrollState.IDLE) {
            return true;
        }
        this.f10955b.f9358c.f9277a = null;
        this.f10955b.mo2185a(this.f10954a);
        return false;
    }
}

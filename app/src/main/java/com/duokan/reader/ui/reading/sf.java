package com.duokan.reader.ui.reading;

import com.duokan.core.sys.s;
import com.duokan.core.ui.Scrollable.ScrollState;

class sf implements s {
    final /* synthetic */ boolean a;
    final /* synthetic */ rx b;

    sf(rx rxVar, boolean z) {
        this.b = rxVar;
        this.a = z;
    }

    public boolean idleRun() {
        if (this.b.c.a != this || this.b.c.q) {
            return false;
        }
        if (this.b.c.e.getShowingPagesView().getScrollState() != ScrollState.IDLE) {
            return true;
        }
        this.b.c.a = null;
        this.b.a(this.a);
        return false;
    }
}

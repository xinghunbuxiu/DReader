package com.duokan.reader.ui.general;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.OnScrollListener;

class bv implements OnScrollListener {
    final /* synthetic */ DotScrollerView a;

    bv(DotScrollerView dotScrollerView) {
        this.a = dotScrollerView;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (this.a.c != null) {
            this.a.c.a(scrollable, scrollState, scrollState2);
        }
    }

    public void a(Scrollable scrollable, boolean z) {
        this.a.a();
        if (this.a.c != null) {
            this.a.c.a(scrollable, z);
        }
    }
}

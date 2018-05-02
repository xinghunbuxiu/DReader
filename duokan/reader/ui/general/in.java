package com.duokan.reader.ui.general;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.OnScrollListener;

class in implements OnScrollListener {
    final /* synthetic */ ik a;

    in(ik ikVar) {
        this.a = ikVar;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
    }

    public void a(Scrollable scrollable, boolean z) {
        this.a.d.invalidate();
    }
}

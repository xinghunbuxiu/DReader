package com.duokan.reader.ui.reading;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.OnScrollListener;

class ke implements OnScrollListener {
    final /* synthetic */ kd a;

    ke(kd kdVar) {
        this.a = kdVar;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (this.a.g != null && scrollState2 == ScrollState.FLING && scrollable.getViewportBounds().top > 0) {
            this.a.d();
            a.k().e("reading/hang-MyTask/" + this.a.g.a + "/ignore");
        }
    }

    public void a(Scrollable scrollable, boolean z) {
        if (this.a.g != null && scrollable.getScrollState() == ScrollState.DRAG && ((float) scrollable.getViewportBounds().top) < ((float) (-scrollable.getMaxOverScrollHeight())) * 0.9f) {
            this.a.a(this.a.g.f.toString());
        }
    }
}

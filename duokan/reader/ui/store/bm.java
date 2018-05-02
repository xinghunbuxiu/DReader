package com.duokan.reader.ui.store;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.OnScrollListener;
import com.duokan.reader.ReaderFeature;

class bm implements OnScrollListener {
    int a = 0;
    final /* synthetic */ bl b;

    bm(bl blVar) {
        this.b = blVar;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        this.b.a(scrollState, scrollState2);
    }

    public void a(Scrollable scrollable, boolean z) {
        if (z) {
            this.b.h = scrollable.getViewportBounds().top;
            boolean z2 = this.b.h > 0;
            if (this.b.i != z2) {
                this.b.i = z2;
                ((ReaderFeature) this.b.getContext().queryFeature(ReaderFeature.class)).updateSystemUi(true);
            }
            int e = this.b.h - this.a;
            this.a = this.b.h;
            this.b.a(scrollable, this.b.h, e);
        }
    }
}

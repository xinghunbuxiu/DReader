package com.duokan.reader.ui.store;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.OnScrollListener;
import com.duokan.reader.ReaderFeature;

class bm implements OnScrollListener {
    /* renamed from: a */
    int f11375a = 0;
    /* renamed from: b */
    final /* synthetic */ bl f11376b;

    bm(bl blVar) {
        this.f11376b = blVar;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        this.f11376b.m15277a(scrollState, scrollState2);
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
        if (z) {
            this.f11376b.f11350h = scrollable.getViewportBounds().top;
            boolean z2 = this.f11376b.f11350h > 0;
            if (this.f11376b.f11351i != z2) {
                this.f11376b.f11351i = z2;
                ((ReaderFeature) this.f11376b.getContext().queryFeature(ReaderFeature.class)).updateSystemUi(true);
            }
            int e = this.f11376b.f11350h - this.f11375a;
            this.f11375a = this.f11376b.f11350h;
            this.f11376b.m15278a(scrollable, this.f11376b.f11350h, e);
        }
    }
}

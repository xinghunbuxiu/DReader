package com.duokan.reader.ui.general;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;

class fz implements cg {
    final /* synthetic */ PagesView a;

    fz(PagesView pagesView) {
        this.a = pagesView;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        this.a.a(scrollState, scrollState2);
        if (this.a.k != null) {
            this.a.k.a(scrollable, scrollState, scrollState2);
        }
    }

    public void a(Scrollable scrollable, boolean z) {
        this.a.a(z);
        if (this.a.k != null) {
            this.a.k.a(scrollable, z);
        }
    }
}

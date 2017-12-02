package com.duokan.reader.ui.bookshelf;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;

class fp implements cg {
    final /* synthetic */ fh a;

    fp(fh fhVar) {
        this.a = fhVar;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
    }

    public void a(Scrollable scrollable, boolean z) {
        this.a.c.invalidate();
    }
}

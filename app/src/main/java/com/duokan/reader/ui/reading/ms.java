package com.duokan.reader.ui.reading;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;

class ms implements cg {
    final /* synthetic */ mr a;

    ms(mr mrVar) {
        this.a = mrVar;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        this.a.a.invalidate();
    }

    public void a(Scrollable scrollable, boolean z) {
        this.a.a.invalidate();
    }
}

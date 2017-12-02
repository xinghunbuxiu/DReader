package com.duokan.reader.ui.a;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;
import com.duokan.core.ui.dv;

class b implements cg {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.DRAG) {
            dv.a(this.a.getContext());
        }
    }

    public void a(Scrollable scrollable, boolean z) {
    }
}

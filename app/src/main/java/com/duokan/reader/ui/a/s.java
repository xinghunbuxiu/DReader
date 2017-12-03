package com.duokan.reader.ui.a;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;
import com.duokan.core.ui.UTools;

class s implements cg {
    final /* synthetic */ n a;

    s(n nVar) {
        this.a = nVar;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.DRAG || scrollState2 == ScrollState.FLING) {
            UTools.hideSoftInputFromWindow(this.a.getContext());
        }
    }

    public void a(Scrollable scrollable, boolean z) {
    }
}

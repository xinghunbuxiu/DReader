package com.duokan.reader.ui.personal;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;
import com.duokan.reader.ui.general.ReaderUi;

class nr implements cg {
    final /* synthetic */ nm a;

    nr(nm nmVar) {
        this.a = nmVar;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.DRAG) {
            ReaderUi.a(this.a.getContext(), this.a.f);
        }
    }

    public void a(Scrollable scrollable, boolean z) {
    }
}

package com.duokan.reader.ui.personal;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;
import com.duokan.reader.ui.general.ReaderUi;

class of implements cg {
    /* renamed from: a */
    final /* synthetic */ oa f9035a;

    of(oa oaVar) {
        this.f9035a = oaVar;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.DRAG) {
            ReaderUi.m10161a(this.f9035a.getContext(), this.f9035a.f8373g);
        }
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
    }
}

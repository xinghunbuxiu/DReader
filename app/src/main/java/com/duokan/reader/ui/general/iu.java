package com.duokan.reader.ui.general;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;

class iu implements cg {
    /* renamed from: a */
    final /* synthetic */ ir f7409a;

    iu(ir irVar) {
        this.f7409a = irVar;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.IDLE) {
            if (this.f7409a.f7402e.m1282c() && !this.f7409a.f7402e.m1283d()) {
                this.f7409a.f7400c.setVisibility(4);
                this.f7409a.f7401d.setVisibility(0);
            } else if (this.f7409a.f7402e.m1283d() && !this.f7409a.f7402e.m1282c()) {
                this.f7409a.f7400c.setVisibility(0);
                this.f7409a.f7401d.setVisibility(4);
            }
        }
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
    }
}

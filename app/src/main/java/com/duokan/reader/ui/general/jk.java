package com.duokan.reader.ui.general;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;

class jk implements cg {
    final /* synthetic */ jh a;

    jk(jh jhVar) {
        this.a = jhVar;
    }

    public void a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState2 == ScrollState.IDLE) {
            if (this.a.e.c() && !this.a.e.d()) {
                this.a.c.setVisibility(4);
                this.a.d.setVisibility(0);
            } else if (this.a.e.d() && !this.a.e.c()) {
                this.a.c.setVisibility(0);
                this.a.d.setVisibility(4);
            }
        }
    }

    public void a(Scrollable scrollable, boolean z) {
    }
}

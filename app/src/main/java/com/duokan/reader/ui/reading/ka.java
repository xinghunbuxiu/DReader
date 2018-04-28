package com.duokan.reader.ui.reading;

import com.duokan.core.ui.Scrollable;
import com.duokan.core.ui.Scrollable.ScrollState;
import com.duokan.core.ui.cg;

class ka implements cg {
    /* renamed from: a */
    final /* synthetic */ jz f10487a;

    ka(jz jzVar) {
        this.f10487a = jzVar;
    }

    /* renamed from: a */
    public void mo478a(Scrollable scrollable, ScrollState scrollState, ScrollState scrollState2) {
        if (scrollState != scrollState2) {
            for (int i = 0; i < this.f10487a.f10481d.getChildCount(); i++) {
                ky kyVar = (ky) this.f10487a.f10481d.getChildAt(i);
                if (scrollState2 == ScrollState.IDLE && this.f10487a.f10479b) {
                    kyVar.mo2406k();
                } else {
                    kyVar.mo2407l();
                }
            }
        }
    }

    /* renamed from: a */
    public void mo479a(Scrollable scrollable, boolean z) {
    }
}

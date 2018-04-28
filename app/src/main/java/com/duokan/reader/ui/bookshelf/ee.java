package com.duokan.reader.ui.bookshelf;

import android.view.View;
import com.duokan.core.app.AppContext;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.C0800c;

class ee implements an {
    /* renamed from: a */
    final /* synthetic */ ec f6379a;

    ee(ec ecVar) {
        this.f6379a = ecVar;
    }

    /* renamed from: a */
    public void mo1558a(HatGridView hatGridView, View view, int i) {
        com.duokan.reader.domain.bookshelf.an anVar = (com.duokan.reader.domain.bookshelf.an) this.f6379a.f6370b.mo509d(i);
        if (this.f6379a.f6373e.mo1657b()) {
            if (this.f6379a.f6373e.mo1651a(anVar)) {
                this.f6379a.f6373e.mo1655b(anVar);
                return;
            }
            this.f6379a.f6373e.mo1649a(anVar);
        } else if (anVar instanceof C0800c) {
            ((ReaderFeature) AppContext.getAppContext(this.f6379a.getContext()).queryFeature(ReaderFeature.class)).openBook((C0800c) anVar);
        }
    }
}

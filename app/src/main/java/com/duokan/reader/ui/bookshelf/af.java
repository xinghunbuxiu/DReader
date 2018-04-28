package com.duokan.reader.ui.bookshelf;

import android.view.View;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.aa;

class af implements an {
    /* renamed from: a */
    final /* synthetic */ C1290g f6091a;

    af(C1290g c1290g) {
        this.f6091a = c1290g;
    }

    /* renamed from: a */
    public void mo1558a(HatGridView hatGridView, View view, int i) {
        com.duokan.reader.domain.bookshelf.an anVar = (com.duokan.reader.domain.bookshelf.an) this.f6091a.f6485e.mo509d(i);
        if (this.f6091a.f6483c.mo1657b()) {
            if (anVar.aA()) {
                if (this.f6091a.f6483c.mo1651a(anVar)) {
                    this.f6091a.f6483c.mo1655b(anVar);
                    return;
                }
                this.f6091a.f6483c.mo1649a(anVar);
            } else if (anVar.aM()) {
                this.f6091a.m9660a((aa) anVar, false);
            }
        } else if (anVar.aA()) {
            this.f6091a.f6481a.openBook((C0800c) anVar);
        } else if (anVar.aM()) {
            this.f6091a.m9660a((aa) anVar, false);
        }
    }
}

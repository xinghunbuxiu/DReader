package com.duokan.reader.ui.bookshelf;

import android.view.View;

import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.c;

class y implements an {
    final /* synthetic */ g a;

    y(g gVar) {
        this.a = gVar;
    }

    public void a(HatGridView hatGridView, View view, int i) {
        com.duokan.reader.domain.bookshelf.an anVar = (com.duokan.reader.domain.bookshelf.an) this.a.e.d(i);
        if (this.a.c.b()) {
            if (anVar.ay()) {
                if (this.a.c.a(anVar)) {
                    this.a.c.b(anVar);
                    return;
                }
                this.a.c.a(anVar);
            } else if (anVar.aK()) {
                this.a.a((aa) anVar, false);
            }
        } else if (anVar.ay()) {
            this.a.a.openBook((c) anVar);
        } else if (anVar.aK()) {
            this.a.a((aa) anVar, false);
        }
    }
}

package com.duokan.reader.ui.bookshelf;

import android.view.View;

import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.an;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.bookshelf.c;

class dw implements an {
    final /* synthetic */ du a;

    dw(du duVar) {
        this.a = duVar;
    }

    public void a(HatGridView hatGridView, View view, int i) {
        com.duokan.reader.domain.bookshelf.an anVar = (com.duokan.reader.domain.bookshelf.an) this.a.b.d(i);
        if (this.a.e.b()) {
            if (this.a.e.a(anVar)) {
                this.a.e.b(anVar);
                return;
            }
            this.a.e.a(anVar);
        } else if (anVar instanceof c) {
            ((ReaderFeature) MyContextWrapper.getFeature(this.a.getContext()).queryFeature(ReaderFeature.class)).openBook((c) anVar);
        }
    }
}

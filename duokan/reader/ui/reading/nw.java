package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.core.ui.ay;
import com.duokan.core.ui.bf;
import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.document.d;

class nw implements bf {
    final /* synthetic */ nk a;

    nw(nk nkVar) {
        this.a = nkVar;
    }

    public void a(ay ayVar, View view, int i) {
        this.a.b.aP();
        a aVar = (a) ayVar.getAdapter().d(i);
        this.a.b.d(this.a.b.getDocument().a((d) aVar.d(), (d) aVar.e()));
    }
}

package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.core.ui.ay;
import com.duokan.core.ui.bg;
import com.duokan.reader.domain.bookshelf.ah;

class nv implements bg {
    final /* synthetic */ nk a;

    nv(nk nkVar) {
        this.a = nkVar;
    }

    public void a(ay ayVar, View view, int i) {
        ny nyVar = (ny) ayVar.getAdapter();
        this.a.c.a(nyVar.a, (ah) nyVar.d(i));
    }
}

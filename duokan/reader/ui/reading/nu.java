package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.core.ui.ay;
import com.duokan.core.ui.bf;
import com.duokan.reader.domain.bookshelf.a;

class nu implements bf {
    final /* synthetic */ nk a;

    nu(nk nkVar) {
        this.a = nkVar;
    }

    public void a(ay ayVar, View view, int i) {
        this.a.b.aP();
        this.a.b.a(((a) ayVar.getAdapter().d(i)).d());
    }
}

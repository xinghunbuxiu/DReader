package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.core.ui.ay;
import com.duokan.core.ui.bf;
import com.duokan.reader.domain.document.g;
import com.duokan.reader.ui.general.cd;

class nr implements bf {
    final /* synthetic */ nk a;

    nr(nk nkVar) {
        this.a = nkVar;
    }

    public void a(ay ayVar, View view, int i) {
        int[] b = this.a.h.b(i);
        this.a.a((g) ((cd) this.a.g.getAdapter()).b(b[0], b[1]));
    }
}

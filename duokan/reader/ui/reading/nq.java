package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.reader.domain.document.g;
import com.duokan.reader.ui.general.cd;
import com.duokan.reader.ui.general.cf;

class nq implements cf {
    final /* synthetic */ nk a;

    nq(nk nkVar) {
        this.a = nkVar;
    }

    public boolean a(View view, int i) {
        this.a.b.aP();
        this.a.a((g) ((cd) this.a.g.getAdapter()).i(i));
        return true;
    }
}

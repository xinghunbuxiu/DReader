package com.duokan.reader.ui.reading;

import android.view.View;

import com.duokan.core.ui.OnItemLongPressListener;
import com.duokan.core.ui.ay;
import com.duokan.reader.domain.bookshelf.ah;

class of implements OnItemLongPressListener {
    /* renamed from: a */
    final /* synthetic */ nu f10734a;

    of(nu nuVar) {
        this.f10734a = nuVar;
    }

    /* renamed from: a */
    public void onItemLongPress(ay ayVar, View view, int i) {
        oi oiVar = (oi) ayVar.getAdapter();
        this.f10734a.f10701c.mo2450a(oiVar.f10737a, (ah) oiVar.mo509d(i));
    }
}

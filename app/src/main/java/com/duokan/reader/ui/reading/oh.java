package com.duokan.reader.ui.reading;

import android.view.View;
import com.duokan.core.ui.ay;
import com.duokan.core.ui.OnItemLongPressListener;
import com.duokan.reader.domain.bookshelf.ea;

class oh implements OnItemLongPressListener {
    /* renamed from: a */
    final /* synthetic */ nu f10736a;

    oh(nu nuVar) {
        this.f10736a = nuVar;
    }

    /* renamed from: a */
    public void onItemLongPress(ay ayVar, View view, int i) {
        oi oiVar = (oi) ayVar.getAdapter();
        this.f10736a.f10701c.mo2451a(oiVar.f10737a, (ea) oiVar.mo509d(i));
    }
}

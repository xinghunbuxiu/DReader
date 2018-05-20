package com.duokan.reader.ui.reading;

import android.view.View;
import com.duokan.core.ui.ay;
import com.duokan.core.ui.OnItemClickListener;
import com.duokan.reader.domain.bookshelf.C0798a;

class oe implements OnItemClickListener {
    /* renamed from: a */
    final /* synthetic */ nu f10733a;

    oe(nu nuVar) {
        this.f10733a = nuVar;
    }

    /* renamed from: a */
    public void onItemClick(ay ayVar, View view, int i) {
        this.f10733a.f10700b.aP();
        this.f10733a.f10700b.mo2024a(((C0798a) ayVar.getAdapter().mo509d(i)).m3726d());
    }
}

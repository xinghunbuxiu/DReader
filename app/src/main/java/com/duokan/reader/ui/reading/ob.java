package com.duokan.reader.ui.reading;

import android.view.View;
import com.duokan.core.ui.ay;
import com.duokan.core.ui.OnItemClickListener;
import com.duokan.reader.domain.document.C0901g;
import com.duokan.reader.ui.general.cd;

class ob implements OnItemClickListener {
    /* renamed from: a */
    final /* synthetic */ nu f10729a;

    ob(nu nuVar) {
        this.f10729a = nuVar;
    }

    /* renamed from: a */
    public void onItemClick(ay ayVar, View view, int i) {
        int[] b = this.f10729a.f10706h.m1404b(i);
        this.f10729a.m14767a((C0901g) ((cd) this.f10729a.f10705g.getAdapter()).mo2456b(b[0], b[1]));
    }
}

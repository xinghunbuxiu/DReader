package com.duokan.reader.ui.bookshelf;

import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.hq;
import java.util.Arrays;

class hc implements hq {
    /* renamed from: a */
    final /* synthetic */ hb f6541a;

    hc(hb hbVar) {
        this.f6541a = hbVar;
    }

    /* renamed from: a */
    public void mo1590a(int i) {
        if (i == 0) {
            UmengManager.get().onEvent("V2_SHELF_DELETEBOOK", "FromList");
            this.f6541a.f6540b.mo1648a(Arrays.asList(new C0800c[]{this.f6541a.f6539a}), null, null);
        } else if (1 == i) {
            new hk(this.f6541a.getContext(), this.f6541a.f6539a).show();
        }
    }
}

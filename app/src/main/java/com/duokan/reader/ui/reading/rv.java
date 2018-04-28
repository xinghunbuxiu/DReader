package com.duokan.reader.ui.reading;

import android.view.View;
import com.duokan.reader.UmengManager;
import com.duokan.reader.ui.general.PagesView;
import com.duokan.reader.ui.general.fw;
import com.duokan.reader.ui.general.gc;

class rv implements fw {
    /* renamed from: a */
    final /* synthetic */ qr f10918a;

    rv(qr qrVar) {
        this.f10918a = qrVar;
    }

    /* renamed from: a */
    public void mo2482a(PagesView pagesView, gc gcVar, gc gcVar2) {
        if (gcVar2 != null) {
            View d = gcVar2.mo2328d();
            if ((d instanceof gx) && ((gx) d).f10283b.mo2282b() == 8) {
                UmengManager.get().onEvent("READING_PURCHASE_PAGE", "SHOW");
            }
            this.f10918a.f9264C = null;
            this.f10918a.f9302z = this.f10918a.f9301y;
            this.f10918a.f9301y = ((gs) gcVar2).mo2331g();
            this.f10918a.mo2350a((gs) gcVar, (gs) gcVar2);
            this.f10918a.m12788a(this.f10918a.f9302z, this.f10918a.f9279c.mo2009Z());
        }
    }
}

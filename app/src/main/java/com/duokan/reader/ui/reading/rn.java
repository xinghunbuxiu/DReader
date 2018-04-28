package com.duokan.reader.ui.reading;

import com.duokan.core.app.ag;
import com.duokan.core.app.ah;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.bookshelf.ee;

class rn implements ah {
    /* renamed from: a */
    final /* synthetic */ Runnable f10904a;
    /* renamed from: b */
    final /* synthetic */ qr f10905b;

    rn(qr qrVar, Runnable runnable) {
        this.f10905b = qrVar;
        this.f10904a = runnable;
    }

    /* renamed from: a */
    public void mo1562a(ag agVar) {
        UmengManager.get().onEvent("READING_ADD_BOOKA", "YES");
        if (this.f10905b.f9282f.ak() && (this.f10905b.f9282f instanceof ee)) {
            ee eeVar = (ee) this.f10905b.f9282f;
            eeVar.m4405a(new ro(this, eeVar));
        } else if (this.f10905b.f9282f.m4167T() && this.f10905b.f9282f.aq() == -1) {
            com.duokan.core.sys.ah.m871b(new rq(this));
        }
    }

    /* renamed from: b */
    public void mo1567b(ag agVar) {
        ((ReaderFeature) this.f10905b.getContext().queryFeature(ReaderFeature.class)).setQuitOnBack(true);
        UmengManager.get().onEvent("READING_ADD_BOOKA", "NO");
        this.f10904a.run();
    }

    /* renamed from: c */
    public void mo1565c(ag agVar) {
        ((ReaderFeature) this.f10905b.getContext().queryFeature(ReaderFeature.class)).setQuitOnBack(true);
        UmengManager.get().onEvent("READING_ADD_BOOKA", "NO");
        this.f10904a.run();
    }
}

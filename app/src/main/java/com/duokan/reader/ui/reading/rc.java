package com.duokan.reader.ui.reading;

import com.duokan.core.app.af;
import com.duokan.core.app.ag;
import com.duokan.core.sys.ah;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.bookshelf.ej;

class rc implements ag {
    final /* synthetic */ Runnable a;
    final /* synthetic */ qh b;

    rc(qh qhVar, Runnable runnable) {
        this.b = qhVar;
        this.a = runnable;
    }

    public void a(af afVar) {
        UmengManager.get().onEvent("READING_ADD_BOOKA", "YES");
        if (this.b.f.ai() && (this.b.f instanceof ej)) {
            ej ejVar = (ej) this.b.f;
            ejVar.a(new rd(this, ejVar));
        } else if (this.b.f.R() && this.b.f.ao() == -1) {
            ah.submitFuture(new rf(this));
        }
    }

    public void b(af afVar) {
        ((ReaderFeature) this.b.getContext().queryFeature(ReaderFeature.class)).setQuitOnBack(true);
        UmengManager.get().onEvent("READING_ADD_BOOKA", "NO");
        this.a.run();
    }

    public void c(af afVar) {
        UmengManager.get().onEvent("READING_ADD_BOOKA", "NO");
        this.a.run();
    }
}

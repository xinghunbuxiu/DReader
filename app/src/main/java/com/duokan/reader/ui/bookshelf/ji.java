package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.ag;
import com.duokan.core.app.ah;
import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.bookshelf.ai;

class ji implements ah {
    /* renamed from: a */
    final /* synthetic */ Runnable f6662a;
    /* renamed from: b */
    final /* synthetic */ jh f6663b;

    ji(jh jhVar, Runnable runnable) {
        this.f6663b = jhVar;
        this.f6662a = runnable;
    }

    /* renamed from: a */
    public void mo1562a(ag agVar) {
        ai.m3980a().mo972a(true);
        UThread.post(this.f6662a);
    }

    /* renamed from: b */
    public void mo1567b(ag agVar) {
        ai.m3980a().mo972a(false);
        UThread.post(this.f6662a);
    }

    /* renamed from: c */
    public void mo1565c(ag agVar) {
    }
}

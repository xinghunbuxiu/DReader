package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.UThread;
import com.duokan.reader.ui.general.dj;

class fq implements dj {
    /* renamed from: a */
    final /* synthetic */ Runnable f6464a;
    /* renamed from: b */
    final /* synthetic */ fo f6465b;

    fq(fo foVar, Runnable runnable) {
        this.f6465b = foVar;
        this.f6464a = runnable;
    }

    public boolean onBack() {
        UThread.post(this.f6464a);
        return true;
    }
}

package com.duokan.reader.ui.general.web;

import com.duokan.reader.ui.general.ja;
import java.util.concurrent.Callable;

class iy implements Callable<ja> {
    /* renamed from: a */
    final /* synthetic */ ix f8023a;

    iy(ix ixVar) {
        this.f8023a = ixVar;
    }

    public /* synthetic */ Object call() {
        return m11209a();
    }

    /* renamed from: a */
    public ja m11209a() {
        ja jaVar = new ja(this.f8023a.f8022b.f7581b.getContext());
        jaVar.show();
        return jaVar;
    }
}

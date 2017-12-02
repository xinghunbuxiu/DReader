package com.duokan.reader.ui.surfing;

import com.duokan.core.app.e;
import com.duokan.core.sys.t;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;

class ac implements u {
    final /* synthetic */ e a;
    final /* synthetic */ boolean b;
    final /* synthetic */ boolean c;
    final /* synthetic */ Runnable d;
    final /* synthetic */ ab e;

    ac(ab abVar, e eVar, boolean z, boolean z2, Runnable runnable) {
        this.e = abVar;
        this.a = eVar;
        this.b = z;
        this.c = z2;
        this.d = runnable;
    }

    public void onQueryAccountOk(a aVar) {
        this.e.a(this.a, this.b, this.c, this.d);
    }

    public void onQueryAccountError(a aVar, String str) {
        t.b(this.d);
    }
}

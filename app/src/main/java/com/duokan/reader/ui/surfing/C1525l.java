package com.duokan.reader.ui.surfing;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.UThread;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;

/* renamed from: com.duokan.reader.ui.surfing.l */
class C1525l implements C0666x {
    /* renamed from: a */
    final /* synthetic */ ActivatedController f11565a;
    /* renamed from: b */
    final /* synthetic */ boolean f11566b;
    /* renamed from: c */
    final /* synthetic */ boolean f11567c;
    /* renamed from: d */
    final /* synthetic */ Runnable f11568d;
    /* renamed from: e */
    final /* synthetic */ C1524k f11569e;

    C1525l(C1524k c1524k, ActivatedController c0303e, boolean z, boolean z2, Runnable runnable) {
        this.f11569e = c1524k;
        this.f11565a = c0303e;
        this.f11566b = z;
        this.f11567c = z2;
        this.f11568d = runnable;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f11569e.m15541a(this.f11565a, this.f11566b, this.f11567c, this.f11568d);
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        UThread.post(this.f11568d);
    }
}

package com.duokan.reader.ui.personal;

import com.duokan.reader.common.async.a.a;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;

class le implements a {
    final /* synthetic */ boolean a;
    final /* synthetic */ kc b;
    final /* synthetic */ ko c;

    le(ko koVar, boolean z, kc kcVar) {
        this.c = koVar;
        this.a = z;
        this.b = kcVar;
    }

    public void a(Void voidR) {
        if (this.a || DkUserPurchasedFictionsManager.a().d()) {
            DkUserPurchasedFictionsManager.a().b(true, false, new lf(this));
            return;
        }
        this.b.g = false;
        this.c.a(this.b);
    }

    public void a(int i, String str) {
        this.b.g = false;
        this.c.a(this.b);
    }
}

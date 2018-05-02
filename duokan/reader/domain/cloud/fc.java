package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.a.a;

class fc implements a {
    final /* synthetic */ boolean a;
    final /* synthetic */ boolean b;
    final /* synthetic */ fm c;
    final /* synthetic */ DkUserReadingNotesManager d;

    fc(DkUserReadingNotesManager dkUserReadingNotesManager, boolean z, boolean z2, fm fmVar) {
        this.d = dkUserReadingNotesManager;
        this.a = z;
        this.b = z2;
        this.c = fmVar;
    }

    public void a(Void voidR) {
        DkUserPurchasedFictionsManager.a().a(new fd(this));
    }

    public void a(int i, String str) {
        this.c.a("");
    }
}

package com.duokan.reader.ui.bookshelf;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.ui.personal.C1416x;
import com.duokan.reader.ui.personal.ku;

class dr implements C0666x {
    /* renamed from: a */
    final /* synthetic */ dq f6356a;

    dr(dq dqVar) {
        this.f6356a = dqVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        ActivatedController kuVar;
        if (C0709k.m3476a().m3508d() == null || C0709k.m3476a().m3508d().mo839i()) {
            kuVar = new ku(this.f6356a.f6355a.f6354a.getContext());
        } else {
            kuVar = new C1416x(this.f6356a.f6355a.f6354a.getContext());
        }
        this.f6356a.f6355a.f6354a.f6348a.pushPageSmoothly(kuVar, null);
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
    }
}

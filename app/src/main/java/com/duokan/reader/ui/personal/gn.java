package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import java.util.concurrent.Callable;

class gn implements Callable<ActivatedController> {
    /* renamed from: a */
    final /* synthetic */ gm f8615a;

    gn(gm gmVar) {
        this.f8615a = gmVar;
    }

    public /* synthetic */ Object call() {
        return m11935a();
    }

    /* renamed from: a */
    public ActivatedController m11935a() {
        PersonalPrefs.m5175a().m5230g(false);
        if (C0709k.m3476a().m3508d() == null || C0709k.m3476a().m3508d().mo839i()) {
            return new ku(this.f8615a.f8614a.getContext());
        }
        return new C1416x(this.f8615a.f8614a.getContext());
    }
}

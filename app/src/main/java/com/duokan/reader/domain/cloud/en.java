package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.duokan.C0629b;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;

class en implements C0666x {
    /* renamed from: a */
    final /* synthetic */ eu f3936a;
    /* renamed from: b */
    final /* synthetic */ boolean f3937b;
    /* renamed from: c */
    final /* synthetic */ DkUserReadingNotesManager f3938c;

    en(DkUserReadingNotesManager dkUserReadingNotesManager, eu euVar, boolean z) {
        this.f3938c = dkUserReadingNotesManager;
        this.f3936a = euVar;
        this.f3937b = z;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3938c.f3626d = new al(c0672a);
        al a = this.f3938c.f3626d;
        new eo(this, a.f2360a, C0629b.f2117a, a).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3936a.mo1158a(str);
    }
}

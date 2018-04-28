package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.C0612j;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;

class ep implements C0666x {
    /* renamed from: a */
    final /* synthetic */ eu f3946a;
    /* renamed from: b */
    final /* synthetic */ boolean f3947b;
    /* renamed from: c */
    final /* synthetic */ DkUserReadingNotesManager f3948c;

    ep(DkUserReadingNotesManager dkUserReadingNotesManager, eu euVar, boolean z) {
        this.f3948c = dkUserReadingNotesManager;
        this.f3946a = euVar;
        this.f3947b = z;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3948c.f3626d = new al(c0672a);
        new eq(this, C0612j.f2035a, this.f3948c.f3626d).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f3946a.mo1158a(str);
    }
}

package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.duokan.ae;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;

/* renamed from: com.duokan.reader.domain.social.message.q */
class C1155q implements C0666x {
    /* renamed from: a */
    final /* synthetic */ C1158z f5571a;
    /* renamed from: b */
    final /* synthetic */ C1153o f5572b;

    C1155q(C1153o c1153o, C1158z c1158z) {
        this.f5572b = c1153o;
        this.f5571a = c1158z;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f5572b.f5568f = new al(c0672a);
        new C1156r(this, this.f5572b.f5568f.f2360a, ae.f2100a, this.f5572b.f5568f).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f5571a.mo1521a(false, false);
    }
}

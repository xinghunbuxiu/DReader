package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0517a;
import com.duokan.reader.common.webservices.duokan.C0629b;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;

class az implements C0666x {
    /* renamed from: a */
    final /* synthetic */ C0517a f3729a;
    /* renamed from: b */
    final /* synthetic */ boolean f3730b;
    /* renamed from: c */
    final /* synthetic */ av f3731c;

    az(av avVar, C0517a c0517a, boolean z) {
        this.f3731c = avVar;
        this.f3729a = c0517a;
        this.f3730b = z;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f3731c.f3718f = new al(c0672a);
        new ba(this, this.f3731c.f3718f.f2360a, C0629b.f2117a, c0672a, this.f3731c.f3718f).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        if (this.f3729a != null) {
            this.f3729a.mo729a(-1, str);
        }
    }
}

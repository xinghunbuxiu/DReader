package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.duokan.ae;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;
import java.util.List;

class aj implements C0666x {
    /* renamed from: a */
    final /* synthetic */ List f5511a;
    /* renamed from: b */
    final /* synthetic */ ar f5512b;
    /* renamed from: c */
    final /* synthetic */ DkMessagesManager f5513c;

    aj(DkMessagesManager dkMessagesManager, List list, ar arVar) {
        this.f5513c = dkMessagesManager;
        this.f5511a = list;
        this.f5512b = arVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f5513c.f5479j = new al(c0672a);
        new ak(this, this.f5513c.f5479j.f2360a, ae.f2100a, this.f5513c.f5479j).open();
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f5512b.mo1182a("");
    }
}

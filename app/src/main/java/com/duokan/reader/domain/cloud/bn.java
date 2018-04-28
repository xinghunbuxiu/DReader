package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;

class bn extends WebSession {
    /* renamed from: a */
    final /* synthetic */ al f3764a;
    /* renamed from: b */
    final /* synthetic */ bm f3765b;
    /* renamed from: c */
    private DkCloudPurchasedBook f3766c = null;

    bn(bm bmVar, C0657i c0657i, al alVar) {
        this.f3765b = bmVar;
        this.f3764a = alVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        cj cjVar = new cj(this.f3764a);
        cjVar.m5406a();
        this.f3766c = (DkCloudPurchasedBook) cjVar.queryItem(this.f3765b.f3763a.f3761a.getBookUuid());
        if (this.f3766c != null) {
            this.f3766c.setBookSourceType(this.f3765b.f3763a.f3761a.getBookSourceType());
            cjVar.updateItem(this.f3766c);
        }
    }

    protected void onSessionSucceeded() {
        if (this.f3764a.m3365a(DkUserPurchasedBooksManager.m5051h()) && this.f3766c != null) {
            this.f3765b.f3763a.f3762b.f3608h.m5397a(this.f3766c);
            this.f3765b.f3763a.f3762b.m5050g();
        }
    }

    protected void onSessionFailed() {
    }
}

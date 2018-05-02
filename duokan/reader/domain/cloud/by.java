package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.ab;

class by extends cs {
    final /* synthetic */ ab a;
    final /* synthetic */ bx b;
    private DkCloudPurchasedBook d = null;

    by(bx bxVar, ab abVar) {
        this.b = bxVar;
        this.a = abVar;
        super(bxVar.a.b);
    }

    protected void onSessionTry() {
        cv cvVar = new cv(this.a);
        cvVar.a();
        this.d = (DkCloudPurchasedBook) cvVar.queryItem(this.b.a.a.getBookUuid());
        if (this.d != null) {
            this.d.setBookSourceType(this.b.a.a.getBookSourceType());
            cvVar.updateItem(this.d);
        }
    }

    protected void onSessionSucceeded() {
        if (this.a.a(DkUserPurchasedBooksManager.h()) && this.d != null) {
            this.b.a.b.h.a(this.d);
            this.b.a.b.g();
        }
    }

    protected void onSessionFailed() {
    }
}

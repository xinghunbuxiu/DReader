package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;

import java.util.LinkedList;

class bp extends cs {
    final /* synthetic */ ab a;
    final /* synthetic */ bo b;
    private b d = null;
    private LinkedList e = new LinkedList();

    bp(bo boVar, ab abVar) {
        this.b = boVar;
        this.a = abVar;
        super(boVar.a.c);
    }

    protected void onSessionTry() {
        this.d = new aa((WebSession) this, this.a).a(true, this.b.a.a);
        if (this.d.b == 0) {
            cv cvVar = new cv(this.a);
            cvVar.a();
            for (String queryItem : this.b.a.a) {
                DkCloudPurchasedBook dkCloudPurchasedBook = (DkCloudPurchasedBook) cvVar.queryItem(queryItem);
                if (dkCloudPurchasedBook != null) {
                    dkCloudPurchasedBook.setHidden(true);
                    cvVar.updateItem(dkCloudPurchasedBook);
                    this.e.add(dkCloudPurchasedBook);
                }
            }
        }
    }

    protected void onSessionSucceeded() {
        if (!this.a.a(DkUserPurchasedBooksManager.h())) {
            this.b.a.b.a(-1, "");
        } else if (this.d.b == 1001 || this.d.b == 1002 || this.d.b == 1003) {
            i.f().a(this.a.a, new bq(this));
        } else if (this.d.b != 0) {
            this.b.a.b.a(this.d.b, this.d.c);
        } else {
            if (!this.e.isEmpty()) {
                this.b.a.c.h.a(this.e);
                this.b.a.c.f();
                this.b.a.c.a(this.b.a.a);
            }
            this.b.a.b.a(null);
        }
    }

    protected void onSessionFailed() {
        if (this.a.a(DkUserPurchasedBooksManager.h())) {
            this.b.a.b.a(-1, this.b.a.c.b.getString(com.duokan.b.i.general__shared__network_error));
        } else {
            this.b.a.b.a(-1, "");
        }
    }
}

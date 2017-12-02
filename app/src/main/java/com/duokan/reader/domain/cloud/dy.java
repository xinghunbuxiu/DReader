package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.b;
import com.duokan.reader.common.webservices.duokan.aa;
import com.duokan.reader.domain.account.ab;
import com.duokan.reader.domain.account.i;

import java.util.LinkedList;

class dy extends ef {
    final /* synthetic */ ab a;
    final /* synthetic */ dx b;
    private b d = null;
    private LinkedList e = new LinkedList();

    dy(dx dxVar, ab abVar) {
        this.b = dxVar;
        this.a = abVar;
        super(dxVar.a.c);
    }

    protected void onSessionTry() {
        this.d = new aa((WebSession) this, this.a).b(true, this.b.a.a);
        if (this.d.b == 0) {
            ei eiVar = new ei(this.a);
            eiVar.a();
            for (String queryItem : this.b.a.a) {
                DkCloudPurchasedFiction dkCloudPurchasedFiction = (DkCloudPurchasedFiction) eiVar.queryItem(queryItem);
                if (dkCloudPurchasedFiction != null) {
                    dkCloudPurchasedFiction.setHidden(true);
                    eiVar.updateItem(dkCloudPurchasedFiction);
                    this.e.add(dkCloudPurchasedFiction);
                }
            }
        }
    }

    protected void onSessionSucceeded() {
        if (!this.a.a(DkUserPurchasedFictionsManager.g())) {
            this.b.a.b.a(-1, "");
        } else if (this.d.b == 1001 || this.d.b == 1002 || this.d.b == 1003) {
            i.f().a(this.a.a, new dz(this));
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
        if (this.a.a(DkUserPurchasedFictionsManager.g())) {
            this.b.a.b.a(-1, this.b.a.c.b.getString(com.duokan.b.i.general__shared__network_error));
        } else {
            this.b.a.b.a(-1, "");
        }
    }
}

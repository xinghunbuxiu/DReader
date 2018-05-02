package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.j;
import com.duokan.reader.domain.account.ab;

import java.util.ArrayList;
import java.util.Collection;

class ag extends j {
    final /* synthetic */ Collection a;
    final /* synthetic */ ab b;
    final /* synthetic */ ax c;
    final /* synthetic */ DkMessagesManager d;
    private ArrayList e = new ArrayList(this.a.size());

    ag(DkMessagesManager dkMessagesManager, Collection collection, ab abVar, ax axVar) {
        this.d = dkMessagesManager;
        this.a = collection;
        this.b = abVar;
        this.c = axVar;
    }

    protected void onSessionTry() {
        synchronized (DkMessagesManager.a) {
            av avVar = new av(this.d.e, this.b, this.d.f);
            avVar.a();
            for (String queryItem : this.a) {
                k kVar = (k) avVar.queryItem(queryItem);
                if (kVar != null) {
                    this.e.add(kVar);
                }
            }
        }
    }

    protected void onSessionSucceeded() {
        if (this.d.k.a(this.b)) {
            this.c.a((k[]) this.e.toArray(new k[0]), false);
        } else {
            this.c.a(new k[0], "");
        }
    }

    protected void onSessionFailed() {
        this.c.a(new k[0], "");
    }
}

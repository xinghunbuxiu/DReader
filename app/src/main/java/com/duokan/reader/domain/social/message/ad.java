package com.duokan.reader.domain.social.message;

import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.al;
import java.util.ArrayList;
import java.util.Collection;

class ad extends WebSession {
    /* renamed from: a */
    final /* synthetic */ Collection f5488a;
    /* renamed from: b */
    final /* synthetic */ al f5489b;
    /* renamed from: c */
    final /* synthetic */ as f5490c;
    /* renamed from: d */
    final /* synthetic */ DkMessagesManager f5491d;
    /* renamed from: e */
    private ArrayList<C1151k> f5492e = new ArrayList(this.f5488a.size());

    ad(DkMessagesManager dkMessagesManager, C0657i c0657i, Collection collection, al alVar, as asVar) {
        this.f5491d = dkMessagesManager;
        this.f5488a = collection;
        this.f5489b = alVar;
        this.f5490c = asVar;
        super(c0657i);
    }

    protected void onSessionTry() {
        synchronized (DkMessagesManager.f5470a) {
            aq aqVar = new aq(this.f5491d.f5474e, this.f5489b, this.f5491d.f5475f);
            aqVar.m8529a();
            for (String queryItem : this.f5488a) {
                C1151k c1151k = (C1151k) aqVar.queryItem(queryItem);
                if (c1151k != null) {
                    this.f5492e.add(c1151k);
                }
            }
        }
    }

    protected void onSessionSucceeded() {
        if (this.f5489b.m3365a(this.f5491d.f5479j)) {
            this.f5490c.mo1180a((C1151k[]) this.f5492e.toArray(new C1151k[0]), false);
        } else {
            this.f5490c.mo1179a(new C1151k[0], "");
        }
    }

    protected void onSessionFailed() {
        this.f5490c.mo1179a(new C1151k[0], "");
    }
}

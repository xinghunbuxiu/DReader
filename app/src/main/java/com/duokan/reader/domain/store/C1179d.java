package com.duokan.reader.domain.store;

import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0647u;
import com.duokan.reader.common.webservices.duokan.DkStoreAbsBookInfo;
import com.duokan.reader.domain.account.PersonalAccount;

/* renamed from: com.duokan.reader.domain.store.d */
class C1179d extends WebSession {
    /* renamed from: a */
    DkStoreAbsBook[] f5650a;
    /* renamed from: b */
    boolean f5651b = false;
    /* renamed from: c */
    final /* synthetic */ String f5652c;
    /* renamed from: d */
    final /* synthetic */ int f5653d;
    /* renamed from: e */
    final /* synthetic */ int f5654e;
    /* renamed from: f */
    final /* synthetic */ C1183i f5655f;
    /* renamed from: g */
    final /* synthetic */ C1176a f5656g;

    C1179d(C1176a c1176a, C0657i c0657i, String str, int i, int i2, C1183i c1183i) {
        this.f5656g = c1176a;
        this.f5652c = str;
        this.f5653d = i;
        this.f5654e = i2;
        this.f5655f = c1183i;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0621a a = new C0647u(this, this.f5656g.f5631b.m3502b(PersonalAccount.class)).m3032a(this.f5652c, this.f5653d, this.f5654e);
        if (a.b == 0) {
            this.f5651b = Boolean.valueOf(a.c).booleanValue();
            this.f5650a = new DkStoreAbsBook[((DkStoreAbsBookInfo[]) a.f2058a).length];
            for (int i = 0; i < this.f5650a.length; i++) {
                this.f5650a[i] = new DkStoreAbsBook(((DkStoreAbsBookInfo[]) a.f2058a)[i]);
            }
        }
    }

    protected void onSessionSucceeded() {
        this.f5655f.mo1560a(this.f5650a, this.f5651b);
        this.f5656g.f5634g = null;
    }

    protected void onSessionFailed() {
        this.f5655f.mo1559a(this.f5656g.f5630a.getString(C0247i.general__shared__network_error));
        this.f5656g.f5634g = null;
    }
}

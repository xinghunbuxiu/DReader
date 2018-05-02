package com.duokan.reader.ui.account;

import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.p036b.C0538a;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.account.p043b.C0703c;
import com.duokan.reader.ui.general.C1329do;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;

/* renamed from: com.duokan.reader.ui.account.d */
class C1252d extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0538a f5939a;
    /* renamed from: b */
    final /* synthetic */ String f5940b;
    /* renamed from: c */
    final /* synthetic */ C1329do f5941c;
    /* renamed from: d */
    final /* synthetic */ String f5942d;
    /* renamed from: e */
    final /* synthetic */ C1249a f5943e;
    /* renamed from: f */
    private C0621a<Void> f5944f = null;
    /* renamed from: g */
    private boolean f5945g = false;

    C1252d(C1249a c1249a, C0657i c0657i, C0538a c0538a, String str, C1329do c1329do, String str2) {
        this.f5943e = c1249a;
        this.f5939a = c0538a;
        this.f5940b = str;
        this.f5941c = c1329do;
        this.f5942d = str2;
        super(c0657i);
    }

    protected void onSessionTry() {
        C0703c c0703c = new C0703c(this);
        try {
            if (this.f5939a.m2409i() != null) {
                this.f5944f = c0703c.m3392f(this.f5940b);
            }
        } catch (AuthenticationFailureException e) {
            this.f5945g = true;
            throw e;
        }
    }

    protected void onSessionSucceeded() {
        if (this.f5944f.b == 0) {
            ((MiAccount) C0709k.m3476a().m3502b(MiAccount.class)).m3206f(this.f5940b);
            this.f5941c.mo1780a();
        } else if (TextUtils.isEmpty(this.f5944f.c)) {
            this.f5941c.mo1781a(this.f5943e.getContext().getResources().getString(C0258j.personal__miaccount_change_nickname_view__failed));
        } else {
            this.f5941c.mo1781a(this.f5944f.c);
        }
    }

    protected void onSessionFailed() {
        if (this.f5945g) {
            this.f5939a.m2397a("com.xiaomi", this.f5942d);
            this.f5943e.m8855a(this.f5940b, this.f5941c);
            return;
        }
        this.f5941c.mo1781a(this.f5943e.getContext().getResources().getString(C0258j.general__shared__network_error));
    }
}

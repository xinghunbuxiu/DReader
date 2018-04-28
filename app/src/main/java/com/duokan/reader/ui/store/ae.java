package com.duokan.reader.ui.store;

import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0652z;
import com.duokan.reader.common.webservices.duokan.DkStoreOrderInfo;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.cloud.DkUserPurchasedFictionsManager;
import java.util.Arrays;

class ae extends WebSession {
    /* renamed from: a */
    final /* synthetic */ C0672a f11311a;
    /* renamed from: b */
    final /* synthetic */ ad f11312b;
    /* renamed from: c */
    private C0621a<DkStoreOrderInfo> f11313c;

    ae(ad adVar, C0657i c0657i, C0672a c0672a) {
        this.f11312b = adVar;
        this.f11311a = c0672a;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f11313c = new C0652z((WebSession) this, this.f11311a).m3064b(this.f11312b.f11307a, this.f11312b.f11308b);
    }

    protected void onSessionSucceeded() {
        if (this.f11313c.b == 0) {
            DkUserPurchasedFictionsManager.m5072a().m5098a(this.f11312b.f11307a, Arrays.asList(new String[]{this.f11312b.f11308b}), new af(this));
            return;
        }
        this.f11312b.f11309c.mo1983a(this.f11312b.f11307a, this.f11312b.f11308b, Integer.valueOf(this.f11313c.b));
    }

    protected void onSessionFailed() {
        this.f11312b.f11309c.mo1983a(this.f11312b.f11307a, this.f11312b.f11308b, null);
    }
}

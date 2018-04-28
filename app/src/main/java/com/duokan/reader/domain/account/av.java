package com.duokan.reader.domain.account;

import android.accounts.Account;
import android.app.Activity;
import android.text.TextUtils;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.p036b.C0538a;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.p043b.C0703c;
import com.duokan.reader.domain.social.p048b.C1134a;
import com.duokan.reader.domain.social.p048b.C1136c;
import com.xiaomi.accountsdk.account.data.ExtendedAuthToken;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;

class av extends WebSession {
    /* renamed from: a */
    final /* synthetic */ String f2380a;
    /* renamed from: b */
    final /* synthetic */ C0538a f2381b;
    /* renamed from: c */
    final /* synthetic */ Account f2382c;
    /* renamed from: d */
    final /* synthetic */ C0700d f2383d;
    /* renamed from: e */
    final /* synthetic */ Activity f2384e;
    /* renamed from: f */
    final /* synthetic */ MiAccount f2385f;
    /* renamed from: g */
    private C0621a<C1136c> f2386g = null;
    /* renamed from: h */
    private C0621a<bd> f2387h = null;
    /* renamed from: i */
    private String f2388i = this.f2380a;
    /* renamed from: j */
    private boolean f2389j = false;

    av(MiAccount miAccount, C0657i c0657i, String str, C0538a c0538a, Account account, C0700d c0700d, Activity activity) {
        this.f2385f = miAccount;
        this.f2380a = str;
        this.f2381b = c0538a;
        this.f2382c = account;
        this.f2383d = c0700d;
        this.f2384e = activity;
        super(c0657i);
    }

    protected void onSessionTry() {
        if (TextUtils.isEmpty(this.f2388i)) {
            this.f2388i = this.f2381b.m2392a(this.f2382c, "passportapi", false);
        }
        C0703c c0703c = new C0703c(this);
        ExtendedAuthToken.parse(this.f2388i);
        try {
            this.f2387h = c0703c.m3390a(this.f2382c);
            this.f2386g = new C1134a(this, this.f2385f).m8457f(this.f2385f.f2252e);
        } catch (AuthenticationFailureException e) {
            this.f2389j = true;
            throw e;
        }
    }

    protected void onSessionSucceeded() {
        if (this.f2386g.b == 0) {
            this.f2385f.f2254g.f2405e.f5459b.m8461a((C1136c) this.f2386g.f2058a);
            this.f2385f.f2254g.f2405e.f5458a.mIsVip = this.f2385f.f2254g.f2405e.f5459b.f5461b;
        }
        if (this.f2387h.b == 0) {
            this.f2385f.f2254g.f2405e.f5458a.mIconUrl = ((bd) this.f2387h.f2058a).f2405e.f5458a.mIconUrl;
            this.f2385f.f2254g.f2405e.f5458a.mNickName = ((bd) this.f2387h.f2058a).f2405e.f5458a.mNickName;
            this.f2385f.f2254g.f2403c = ((bd) this.f2387h.f2058a).f2403c;
            this.f2385f.f2254g.f2404d = ((bd) this.f2387h.f2058a).f2404d;
            this.f2385f.m3155l();
            this.f2385f.a.mo881c(this.f2385f);
            if (this.f2383d != null) {
                this.f2383d.mo868a(this.f2385f);
            }
        } else if (this.f2383d != null) {
            this.f2383d.mo869a(this.f2385f, this.f2387h.c);
        }
    }

    protected void onSessionFailed() {
        if (this.f2389j) {
            this.f2381b.m2397a("com.xiaomi", this.f2380a);
            if (this.f2384e != null) {
                this.f2385f.mo829a(this.f2384e, this.f2383d);
            } else {
                this.f2383d.mo869a(this.f2385f, "");
            }
        } else if (this.f2383d != null) {
            this.f2383d.mo869a(this.f2385f, this.f2385f.a.mo877a(C0247i.general__shared__network_error));
        }
    }
}

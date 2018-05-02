package com.duokan.reader.domain.account.p042a;

import android.accounts.Account;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p036b.C0538a;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.statistics.dailystats.C1167a;

/* renamed from: com.duokan.reader.domain.account.a.w */
public class C0695w implements C0673p {
    /* renamed from: a */
    private final MiAccount f2339a;
    /* renamed from: b */
    private final C0676k f2340b;

    public C0695w(MiAccount miAccount, C0676k c0676k) {
        this.f2339a = miAccount;
        this.f2340b = c0676k;
    }

    /* renamed from: a */
    public void mo854a() {
        int i = 1;
        String g = this.f2340b.mo862g();
        String[] split = g.split("ABCDFGXYZ");
        if (split.length == 1) {
            i = 0;
        }
        new C0696x(this, C0689q.f2317a, split[i].split(",")[0], new Account(split[0], "com.xiaomi"), g).open();
    }

    /* renamed from: b */
    private void m3351b() {
        this.f2339a.m3195a(this.f2339a);
        this.f2340b.mo855a(this.f2340b.mo858c());
        C0538a.m2388a(DkApp.get()).m2397a("com.xiaomi", this.f2340b.mo862g());
    }

    /* renamed from: a */
    private void m3350a(String str) {
        C1167a.m8671d().m8682b("f");
        C0538a.m2388a(DkApp.get()).m2397a("com.xiaomi", this.f2340b.mo862g());
        C0673p f = this.f2340b.mo861f();
        f.m3304a(str);
        this.f2340b.mo855a(f);
    }
}

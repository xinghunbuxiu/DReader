package com.duokan.reader.domain.account.p042a;

import android.text.TextUtils;
import com.duokan.reader.DkApp;
import com.duokan.reader.common.p036b.C0542e;
import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.domain.statistics.dailystats.C1167a;
import com.duokan.reader.ui.general.be;

/* renamed from: com.duokan.reader.domain.account.a.i */
public class C0683i implements C0673p, C0420b {
    /* renamed from: a */
    private final MiAccount f2303a;
    /* renamed from: b */
    private final C0676k f2304b;

    public C0683i(MiAccount miAccount, C0676k c0676k) {
        this.f2303a = miAccount;
        this.f2304b = c0676k;
    }

    /* renamed from: a */
    public void mo854a() {
        C0542e.m2412a(DkApp.get(), true).m2395a(new C0684j(this));
    }

    public void onLoginOk(C0672a c0672a) {
        C1167a.m8671d().m8682b("s");
    }

    public void onLoginError(C0672a c0672a, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(DkApp.get(), (CharSequence) str, 1).show();
        }
        C1167a.m8671d().m8682b("f");
        C0673p f = this.f2304b.mo861f();
        f.m3304a(str);
        this.f2304b.mo855a(f);
    }
}

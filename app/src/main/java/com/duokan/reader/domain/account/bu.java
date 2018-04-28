package com.duokan.reader.domain.account;

import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import java.util.List;

public class bu implements am {
    /* renamed from: a */
    private final C0420b f2450a;

    private bu(C0420b c0420b) {
        this.f2450a = c0420b;
    }

    /* renamed from: a */
    public void mo873a() {
        List e = C0709k.m3476a().m3510e();
        e.remove("WX_LOGIN");
        m3424a(DkApp.get().getString(C0247i.account__mi_login_view__title), e, this.f2450a);
    }

    /* renamed from: a */
    private void m3424a(String str, List<String> list, C0420b c0420b) {
        if (list.size() != 1) {
            new ad(DkApp.get().getTopActivity(), str, list, new bv(this, c0420b)).show();
        } else if (list.contains("MI_LOCAL")) {
            C0709k.m3476a().m3504b(c0420b);
        } else {
            C0709k.m3476a().m3492a(c0420b);
        }
    }
}

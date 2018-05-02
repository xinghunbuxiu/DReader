package com.duokan.reader.domain.account;

import com.duokan.reader.DkApp;
import java.util.List;

public class cj implements am {
    /* renamed from: a */
    private final C0420b f2466a;

    private cj(C0420b c0420b) {
        this.f2466a = c0420b;
    }

    /* renamed from: a */
    public void mo873a() {
        m3442a(null, C0709k.m3476a().m3510e(), this.f2466a);
    }

    /* renamed from: a */
    private void m3442a(String str, List<String> list, C0420b c0420b) {
        if (list.size() != 1) {
            new ad(DkApp.get().getTopActivity(), str, list, new ck(this, c0420b)).show();
        } else if (list.contains("MI_LOCAL")) {
            C0709k.m3476a().m3504b(c0420b);
        } else {
            C0709k.m3476a().m3492a(c0420b);
        }
    }
}

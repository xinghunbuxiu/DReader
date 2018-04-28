package com.duokan.reader.domain.account;

import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.ui.general.ja;

public class bo implements am {
    /* renamed from: a */
    private final C0420b f2443a;

    public bo(C0420b c0420b) {
        this.f2443a = c0420b;
    }

    /* renamed from: a */
    public void mo873a() {
        ja jaVar = new ja(DkApp.get().getTopActivity());
        jaVar.m10843a(DkApp.get().getString(C0247i.account__shared__duokan_logging_in));
        jaVar.m10844a(true);
        jaVar.setCancelOnBack(false);
        jaVar.setCancelOnTouchOutside(false);
        jaVar.show();
        C0709k.m3476a().m3509d(new bp(this, jaVar));
    }
}

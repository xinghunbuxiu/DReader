package com.duokan.reader.ui.account;

import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.ui.general.hq;
import com.duokan.reader.ui.general.ja;

/* renamed from: com.duokan.reader.ui.account.r */
class C1266r implements hq {
    /* renamed from: a */
    final /* synthetic */ String f5973a;
    /* renamed from: b */
    final /* synthetic */ C1261m f5974b;

    C1266r(C1261m c1261m, String str) {
        this.f5974b = c1261m;
        this.f5973a = str;
    }

    /* renamed from: a */
    public void mo1590a(int i) {
        if (i == 0) {
            ja jaVar;
            boolean z = this.f5974b.f5963a.canAccessTokenSyncToCloud(this.f5973a) && C0709k.m3476a().m3507c();
            if (z) {
                jaVar = new ja(this.f5974b.getContext());
                jaVar.setCancelOnBack(false);
                jaVar.setCancelOnTouchOutside(false);
                jaVar.m10843a(this.f5974b.getContext().getString(C0258j.account__shared__unbinding_sns));
                jaVar.show();
            } else {
                jaVar = null;
            }
            this.f5974b.f5963a.unbindAccessToken(this.f5974b.getContext(), this.f5973a, new C1267s(this, jaVar));
            return;
        }
        this.f5974b.m9010b(this.f5973a);
    }
}

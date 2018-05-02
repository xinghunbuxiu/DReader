package com.duokan.reader.ui.surfing;

import com.duokan.core.sys.UThread;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiAccount;

/* renamed from: com.duokan.reader.ui.surfing.q */
class C1530q implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1522i f11580a;

    C1530q(C1522i c1522i) {
        this.f11580a = c1522i;
    }

    public void run() {
        if (DkApp.get().getAutoLogin()) {
            MiAccount miAccount = (MiAccount) C0709k.m3476a().m3502b(MiAccount.class);
            if (MiAccount.m3186b(this.f11580a.getContext()) && (miAccount == null || miAccount.mo839i())) {
                C0709k.m3476a().m3506c(new C1531r(this));
                return;
            }
        }
        m15544a();
    }

    /* renamed from: a */
    private void m15544a() {
        UThread.postDelayed(new C1532s(this), 2000);
    }
}

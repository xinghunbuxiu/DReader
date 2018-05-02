package com.duokan.reader.ui.surfing;

import com.duokan.reader.DkApp;
import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.C0672a;

/* renamed from: com.duokan.reader.ui.surfing.r */
class C1531r implements C0420b {
    /* renamed from: a */
    final /* synthetic */ C1530q f11581a;

    C1531r(C1530q c1530q) {
        this.f11581a = c1530q;
    }

    public void onLoginOk(C0672a c0672a) {
        DkApp.get().setAutoLogin(false);
        this.f11581a.m15544a();
    }

    public void onLoginError(C0672a c0672a, String str) {
        DkApp.get().setAutoLogin(false);
        if (this.f11581a.f11580a.f11552t != null && this.f11581a.f11580a.f11552t.isActive()) {
            this.f11581a.f11580a.f11552t.m11925h();
        }
        this.f11581a.m15544a();
    }
}

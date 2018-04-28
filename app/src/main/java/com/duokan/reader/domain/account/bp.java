package com.duokan.reader.domain.account;

import com.duokan.reader.ui.general.ja;

class bp implements C0420b {
    /* renamed from: a */
    final /* synthetic */ ja f2444a;
    /* renamed from: b */
    final /* synthetic */ bo f2445b;

    bp(bo boVar, ja jaVar) {
        this.f2445b = boVar;
        this.f2444a = jaVar;
    }

    public void onLoginOk(C0672a c0672a) {
        this.f2445b.f2443a.onLoginOk(c0672a);
        this.f2444a.dismiss();
    }

    public void onLoginError(C0672a c0672a, String str) {
        this.f2445b.f2443a.onLoginError(c0672a, str);
        this.f2444a.dismiss();
    }
}

package com.duokan.reader.ui.account;

import com.duokan.reader.domain.account.oauth.TokenStore.OnAccessTokenUnbindListener;
import com.duokan.reader.ui.general.ja;

/* renamed from: com.duokan.reader.ui.account.s */
class C1267s implements OnAccessTokenUnbindListener {
    /* renamed from: a */
    final /* synthetic */ ja f5975a;
    /* renamed from: b */
    final /* synthetic */ C1266r f5976b;

    C1267s(C1266r c1266r, ja jaVar) {
        this.f5976b = c1266r;
        this.f5975a = jaVar;
    }

    public void onOk() {
        if (this.f5975a != null && this.f5975a.isShowing()) {
            this.f5975a.dismiss();
        }
        this.f5976b.f5974b.m9007b();
    }
}

package com.duokan.reader.ui.account;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.oauth.ThirdOAuth.QueryAccountListener;

/* renamed from: com.duokan.reader.ui.account.o */
class C1263o implements QueryAccountListener {
    /* renamed from: a */
    final /* synthetic */ C1262n f5970a;

    C1263o(C1262n c1262n) {
        this.f5970a = c1262n;
    }

    public void onQueryAccountOk(String... strArr) {
        ReaderEnv.get().setSyncEvernoteEnabled(true);
        this.f5970a.f5969a.m9007b();
        this.f5970a.f5969a.m9003a();
    }

    public void onQueryAccountError() {
        this.f5970a.f5969a.m9003a();
    }
}

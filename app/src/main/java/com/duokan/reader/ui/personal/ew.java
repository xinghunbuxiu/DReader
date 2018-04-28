package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.MiAccount;
import com.duokan.reader.ui.general.be;
import com.wali.live.sdk.manager.MiLiveSdkController;

class ew implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ev f8527a;

    ew(ev evVar) {
        this.f8527a = evVar;
    }

    public void run() {
        C0672a b = C0709k.m3476a().m3502b(MiAccount.class);
        Object miLiveUser = ReaderEnv.get().getMiLiveUser();
        if (TextUtils.isEmpty(miLiveUser) || !miLiveUser.equals(b.mo832b())) {
            be.m10286a(this.f8527a.f8526a.f8523a, C0258j.general__shared__login_succeed, 0).show();
            ReaderEnv.get().setMiLiveUser(b.mo832b());
        }
        MiLiveSdkController.getInstance().openContestPrepare(this.f8527a.f8526a.f8523a, null);
    }
}

package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.duokan.core.sys.as;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class hf implements as {
    /* renamed from: a */
    final /* synthetic */ String f7924a;
    /* renamed from: b */
    final /* synthetic */ ci f7925b;

    hf(ci ciVar, String str) {
        this.f7925b = ciVar;
        this.f7924a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        C0328a.m757c().m752c(LogLevel.EVENT, "resign_event", "receive_frontend_callback");
        PersonalPrefs.m5175a().m5228f(false);
        UThread.runOnThread(new hg(this));
        DkSignInInfo dkSignInInfo = null;
        if (!TextUtils.isEmpty(this.f7924a)) {
            dkSignInInfo = this.f7925b.f7581b.jsonToDkSignInInfo(this.f7924a, 1);
        }
        UThread.postDelayed(new hh(this, dkSignInInfo), 5000);
    }
}

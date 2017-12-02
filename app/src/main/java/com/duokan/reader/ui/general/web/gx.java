package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.diagnostic.a;
import com.duokan.core.sys.as;
import com.duokan.core.sys.t;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.domain.cloud.PersonalPrefs;

class gx implements as {
    final /* synthetic */ String a;
    final /* synthetic */ cg b;

    gx(cg cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        a.c().c(LogLevel.EVENT, "resign_event", "receive_frontend_callback");
        PersonalPrefs.a().f(false);
        t.a(new gy(this));
        DkSignInInfo dkSignInInfo = null;
        if (!TextUtils.isEmpty(this.a)) {
            dkSignInInfo = this.b.b.jsonToDkSignInInfo(this.a);
        }
        t.a(new gz(this, dkSignInInfo), 5000);
    }
}

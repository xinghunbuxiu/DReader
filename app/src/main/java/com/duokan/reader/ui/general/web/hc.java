package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.sys.as;
import com.duokan.reader.common.webservices.duokan.DkSignInInfo;
import com.duokan.reader.domain.bookshelf.kp;

class hc implements as {
    final /* synthetic */ hb a;

    hc(hb hbVar) {
        this.a = hbVar;
    }

    public void a() {
        if (kp.a() != null) {
            if (TextUtils.isEmpty(this.a.a)) {
                kp.a().b(true);
                return;
            }
            DkSignInInfo jsonToDkSignInInfo = this.a.b.b.jsonToDkSignInInfo(this.a.a);
            if (jsonToDkSignInInfo != null) {
                kp.a().a(jsonToDkSignInInfo);
            }
        }
    }
}

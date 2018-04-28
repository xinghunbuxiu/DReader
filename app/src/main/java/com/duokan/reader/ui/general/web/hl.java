package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.core.sys.as;
import com.duokan.reader.UmengManager;
import com.duokan.reader.domain.bookshelf.lb;

class hl implements as {
    /* renamed from: a */
    final /* synthetic */ hk f7933a;

    hl(hk hkVar) {
        this.f7933a = hkVar;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (lb.m4896a() != null) {
            UmengManager.get().onEvent("PERSONAL_CHECK_IN_CLICK_V2", "签到");
            if (TextUtils.isEmpty(this.f7933a.f7931a)) {
                lb.m4896a().m4915a(null);
                return;
            }
            lb.m4896a().m4915a(this.f7933a.f7932b.f7581b.jsonToDkSignInInfo(this.f7933a.f7931a, 0));
        }
    }
}

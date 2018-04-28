package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.C1329do;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.dn;

class ix implements dn {
    /* renamed from: a */
    final /* synthetic */ iw f8752a;

    ix(iw iwVar) {
        this.f8752a = iwVar;
    }

    /* renamed from: a */
    public void mo1582a(String str, C1329do c1329do) {
        if (TextUtils.isEmpty(str)) {
            be.m10287a(this.f8752a.f8751a.getContext(), this.f8752a.f8751a.getResources().getString(C0258j.personal__personal_redeem_info_view__prompt), 3).show();
            c1329do.mo1781a("");
        } else if (TextUtils.equals(str, this.f8752a.f8751a.f8748a.getMessage())) {
            c1329do.mo1780a();
        } else {
            this.f8752a.f8751a.m12025a(str, c1329do);
        }
    }
}

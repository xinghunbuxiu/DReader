package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.ui.general.be;

class hy implements u {
    final /* synthetic */ hx a;

    hy(hx hxVar) {
        this.a = hxVar;
    }

    public void onQueryAccountOk(a aVar) {
        try {
            this.a.a.b.pushHalfPageSmoothly(new MiAccountProfileSettingsController(this.a.a.getContext()), null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onQueryAccountError(a aVar, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.a(this.a.a.getContext(), (CharSequence) str, 0).show();
        }
    }
}

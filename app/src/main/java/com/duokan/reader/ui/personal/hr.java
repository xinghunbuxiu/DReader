package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.ui.general.be;

class hr implements C0666x {
    /* renamed from: a */
    final /* synthetic */ hq f8670a;

    hr(hq hqVar) {
        this.f8670a = hqVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(this.f8670a.f8669a.getContext(), (CharSequence) str, 0).show();
        }
    }
}

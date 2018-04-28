package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.ui.general.be;

class ht implements C0666x {
    /* renamed from: a */
    final /* synthetic */ hs f8672a;

    ht(hs hsVar) {
        this.f8672a = hsVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        if (!TextUtils.isEmpty(str)) {
            be.m10287a(this.f8672a.f8671a.getContext(), (CharSequence) str, 0).show();
        }
    }
}

package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkPublic;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.ui.general.be;

class cc implements C0666x {
    /* renamed from: a */
    final /* synthetic */ cb f9929a;

    cc(cb cbVar) {
        this.f9929a = cbVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        DkPublic.exchangeNewIdThenDo(this.f9929a.f9928a.f9927a.f.mo1992G().m4156I(), "", new cd(this), null);
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        CharSequence str2;
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f9929a.f9928a.f9927a.getResources().getString(C0258j.reading__comment_view__tip_no_account);
        }
        be.m10287a(this.f9929a.f9928a.f9927a.getContext(), str2, 0).show();
    }
}

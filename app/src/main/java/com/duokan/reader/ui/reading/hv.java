package com.duokan.reader.ui.reading;

import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.DkPublic;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.ui.general.be;

class hv implements u {
    final /* synthetic */ hu a;

    hv(hu huVar) {
        this.a = huVar;
    }

    public void onQueryAccountOk(a aVar) {
        DkPublic.exchangeNewIdThenDo(this.a.a.a.f.G().H(), "", new hw(this), null);
    }

    public void onQueryAccountError(a aVar, String str) {
        CharSequence string;
        if (TextUtils.isEmpty(str)) {
            string = this.a.a.a.getResources().getString(j.reading__comment_view__tip_no_account);
        }
        be.a(this.a.a.a.getContext(), string, 0).show();
    }
}

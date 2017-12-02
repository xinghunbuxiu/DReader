package com.duokan.reader.ui.reading;

import android.text.TextUtils;

import com.duokan.c.j;
import com.duokan.reader.DkPublic;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.ui.general.be;

class dt implements u {
    final /* synthetic */ ds a;

    dt(ds dsVar) {
        this.a = dsVar;
    }

    public void onQueryAccountOk(a aVar) {
        this.a.a.k();
        DkPublic.exchangeNewIdThenDo(this.a.a.y.H(), this.a.a.F, new du(this), null);
    }

    public void onQueryAccountError(a aVar, String str) {
        CharSequence string;
        if (TextUtils.isEmpty(str)) {
            string = this.a.a.getResources().getString(j.reading__comment_view__tip_no_account);
        }
        be.a(this.a.a.getContext(), string, 0).show();
    }
}

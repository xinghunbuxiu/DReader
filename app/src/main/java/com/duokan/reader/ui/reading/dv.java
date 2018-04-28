package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkPublic;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.ui.general.be;

class dv implements C0666x {
    /* renamed from: a */
    final /* synthetic */ du f10049a;

    dv(du duVar) {
        this.f10049a = duVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        this.f10049a.f10048a.m13981k();
        DkPublic.exchangeNewIdThenDo(this.f10049a.f10048a.f10025z.m4156I(), this.f10049a.f10048a.f9998G, new dw(this), null);
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        CharSequence str2;
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f10049a.f10048a.getResources().getString(C0258j.reading__comment_view__tip_no_account);
        }
        be.m10287a(this.f10049a.f10048a.getContext(), str2, 0).show();
    }
}

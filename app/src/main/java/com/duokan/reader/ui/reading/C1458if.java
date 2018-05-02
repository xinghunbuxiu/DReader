package com.duokan.reader.ui.reading;

import android.text.TextUtils;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkPublic;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.ui.general.be;

/* renamed from: com.duokan.reader.ui.reading.if */
class C1458if implements C0666x {
    /* renamed from: a */
    final /* synthetic */ ie f10384a;

    C1458if(ie ieVar) {
        this.f10384a = ieVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        DkPublic.exchangeNewIdThenDo(this.f10384a.f10383a.f10382a.f.mo1992G().m4156I(), "", new ig(this), null);
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        CharSequence str2;
        if (TextUtils.isEmpty(str2)) {
            str2 = this.f10384a.f10383a.f10382a.getResources().getString(C0258j.reading__comment_view__tip_no_account);
        }
        be.m10287a(this.f10384a.f10383a.f10382a.getContext(), str2, 0).show();
    }
}

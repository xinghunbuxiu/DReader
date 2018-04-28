package com.duokan.reader.ui.general.web;

import android.content.SharedPreferences.Editor;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.payment.PaymentManager;
import com.mipay.sdk.Mipay;

class bs implements C0666x {
    /* renamed from: a */
    final /* synthetic */ br f7646a;

    bs(br brVar) {
        this.f7646a = brVar;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        if (this.f7646a.f7641a != null) {
            Editor edit = PersonalPrefs.m5175a().m5244t().edit();
            edit.putString(StorePageController.PAY_CONTINUE, this.f7646a.f7641a.toString());
            edit.apply();
        }
        PaymentManager.m8331a().m8352a(c0672a, this.f7646a.f7642b, this.f7646a.f7643c, this.f7646a.f7643c.mo1504d(), new bt(this));
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
        this.f7646a.f7645e.web_notifyWeb(this.f7646a.f7644d, 2, Mipay.KEY_RESULT, Integer.valueOf(11));
    }
}

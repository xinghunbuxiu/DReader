package com.duokan.reader.ui.general.web;

import android.content.SharedPreferences.Editor;

import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.payment.PaymentManager;
import com.mipay.sdk.Mipay;

class bt implements u {
    final /* synthetic */ bs a;

    bt(bs bsVar) {
        this.a = bsVar;
    }

    public void onQueryAccountOk(a aVar) {
        if (this.a.a != null) {
            Editor edit = PersonalPrefs.a().t().edit();
            edit.putString(StorePageController.PAY_CONTINUE, this.a.a.toString());
            edit.apply();
        }
        PaymentManager.a().a(aVar, this.a.b, this.a.c, this.a.c.d(), new bu(this));
    }

    public void onQueryAccountError(a aVar, String str) {
        this.a.e.web_notifyWeb(this.a.d, 2, Mipay.KEY_RESULT, Integer.valueOf(11));
    }
}

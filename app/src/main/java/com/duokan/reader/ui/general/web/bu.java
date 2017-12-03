package com.duokan.reader.ui.general.web;

import android.content.SharedPreferences.Editor;

import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.payment.PaymentResult;
import com.duokan.reader.domain.payment.s;
import com.duokan.reader.domain.store.DkStoreCallback;
import com.mipay.sdk.Mipay;

class bu implements DkStoreCallback {
    final /* synthetic */ bt a;

    bu(bt btVar) {
        this.a = btVar;
    }

    public void a(s sVar, PaymentResult paymentResult) {
        if (paymentResult == PaymentResult.VERIFIED_OK) {
            this.a.a.e.web_notifyWeb(this.a.a.d, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
        } else {
            this.a.a.e.web_notifyWeb(this.a.a.d, 0, Mipay.KEY_RESULT, Integer.valueOf(12));
        }
        a(true, true);
    }

    public void a(s sVar, String str) {
        this.a.a.e.web_notifyWeb(this.a.a.d, 2, Mipay.KEY_RESULT, Integer.valueOf(11));
        a(true, false);
    }

    public void a(s sVar, String str, AbortPayErrorCode abortPayErrorCode) {
        this.a.a.e.web_notifyWeb(this.a.a.d, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
        a(true, false);
    }

    private void a(boolean z, boolean z2) {
        if (z) {
            Editor edit = PersonalPrefs.a().t().edit();
            edit.remove(StorePageController.PAY_CONTINUE);
            edit.apply();
        }
    }
}

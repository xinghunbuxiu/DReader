package com.duokan.reader.ui.general.web;

import android.content.SharedPreferences.Editor;
import com.duokan.reader.domain.cloud.PersonalPrefs;
import com.duokan.reader.domain.payment.C1089s;
import com.duokan.reader.domain.payment.PaymentResult;
import com.duokan.reader.domain.store.DkStoreCallback;
import com.duokan.reader.domain.store.DkStoreCallback.AbortPayErrorCode;
import com.mipay.sdk.Mipay;

class bt implements DkStoreCallback {
    /* renamed from: a */
    final /* synthetic */ bs f7647a;

    bt(bs bsVar) {
        this.f7647a = bsVar;
    }

    /* renamed from: a */
    public void mo1163a(C1089s c1089s, PaymentResult paymentResult) {
        if (paymentResult == PaymentResult.VERIFIED_OK) {
            this.f7647a.f7646a.f7645e.web_notifyWeb(this.f7647a.f7646a.f7644d, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
        } else {
            this.f7647a.f7646a.f7645e.web_notifyWeb(this.f7647a.f7646a.f7644d, 0, Mipay.KEY_RESULT, Integer.valueOf(12));
        }
        m11055a(true, true);
    }

    /* renamed from: a */
    public void mo1164a(C1089s c1089s, String str) {
        this.f7647a.f7646a.f7645e.web_notifyWeb(this.f7647a.f7646a.f7644d, 2, Mipay.KEY_RESULT, Integer.valueOf(11));
        m11055a(true, false);
    }

    /* renamed from: a */
    public void mo1165a(C1089s c1089s, String str, AbortPayErrorCode abortPayErrorCode) {
        this.f7647a.f7646a.f7645e.web_notifyWeb(this.f7647a.f7646a.f7644d, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str);
        m11055a(true, false);
    }

    /* renamed from: a */
    private void m11055a(boolean z, boolean z2) {
        if (z) {
            Editor edit = PersonalPrefs.m5175a().m5244t().edit();
            edit.remove(StorePageController.PAY_CONTINUE);
            edit.apply();
        }
    }
}

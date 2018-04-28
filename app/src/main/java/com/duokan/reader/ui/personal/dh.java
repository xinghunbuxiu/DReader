package com.duokan.reader.ui.personal;

import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;

class dh implements C0586j {
    /* renamed from: a */
    final /* synthetic */ MiAccountProfileSettingsController f8450a;

    dh(MiAccountProfileSettingsController miAccountProfileSettingsController) {
        this.f8450a = miAccountProfileSettingsController;
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
    }

    public void onAccountLogoff(C0672a c0672a) {
    }

    public void onAccountDetailChanged(C0672a c0672a) {
        this.f8450a.m11353b();
    }
}

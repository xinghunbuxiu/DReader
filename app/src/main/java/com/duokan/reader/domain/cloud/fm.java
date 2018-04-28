package com.duokan.reader.domain.cloud;

import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.cloud.DkSharedStorageManager.SharedKey;

class fm implements C0586j {
    /* renamed from: a */
    final /* synthetic */ fl f4008a;

    fm(fl flVar) {
        this.f4008a = flVar;
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
    }

    public void onAccountLogoff(C0672a c0672a) {
        DkSharedStorageManager.m5016a().m5027b(SharedKey.CART_CACHE);
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }
}

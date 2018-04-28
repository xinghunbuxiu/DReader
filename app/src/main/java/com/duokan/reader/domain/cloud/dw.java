package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0519c;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;

class dw implements C0586j {
    /* renamed from: a */
    final /* synthetic */ DkUserReadBookManager f3893a;

    dw(DkUserReadBookManager dkUserReadBookManager) {
        this.f3893a = dkUserReadBookManager;
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
        this.f3893a.f3622f = new al(this.f3893a.f3619c.m3508d());
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        this.f3893a.m5126a(C0519c.f1752a);
    }

    public void onAccountLogoff(C0672a c0672a) {
        this.f3893a.f3622f = new al();
        this.f3893a.m5119b();
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }
}

package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.async.p035a.C0519c;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;

class aq implements C0586j {
    /* renamed from: a */
    final /* synthetic */ ap f3702a;

    aq(ap apVar) {
        this.f3702a = apVar;
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
        this.f3702a.f3700f = new al(this.f3702a.f3697c.m3508d());
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        this.f3702a.m5303a(C0519c.f1752a);
    }

    public void onAccountLogoff(C0672a c0672a) {
        this.f3702a.f3700f = new al();
        this.f3702a.f3701g = 0;
        this.f3702a.m5300c();
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }
}

package com.duokan.reader.domain.cloud;

import com.duokan.reader.common.C0612j;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;

class eg implements C0586j {
    /* renamed from: a */
    final /* synthetic */ DkUserReadingNotesManager f3922a;

    eg(DkUserReadingNotesManager dkUserReadingNotesManager) {
        this.f3922a = dkUserReadingNotesManager;
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
        this.f3922a.f3626d = new al(c0672a);
        new ev(this.f3922a.f3626d).recover();
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        this.f3922a.m5158c();
    }

    public void onAccountLogoff(C0672a c0672a) {
        new eh(this, C0612j.f2035a, this.f3922a.f3626d).open();
        this.f3922a.f3626d = al.f2359g;
        this.f3922a.f3627e = 0;
        this.f3922a.m5150d();
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }
}

package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;

class dg implements C0586j {
    /* renamed from: a */
    final /* synthetic */ df f3018a;

    dg(df dfVar) {
        this.f3018a = dfVar;
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
        this.f3018a.f3017a.f3011c = new al(c0672a);
        this.f3018a.f3017a.m4330c();
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
    }

    public void onAccountLogoff(C0672a c0672a) {
        if (this.f3018a.f3017a.f3011c.m3367c()) {
            new dh(this, aq.f2771a, this.f3018a.f3017a.f3011c).open();
        }
        this.f3018a.f3017a.f3013e = true;
        this.f3018a.f3017a.f3014f = System.currentTimeMillis();
        this.f3018a.f3017a.f3011c = al.f2359g;
        this.f3018a.f3017a.f3012d = new dv();
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }
}

package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.al;

class bw implements C0586j {
    /* renamed from: a */
    final /* synthetic */ bv f2875a;

    bw(bv bvVar) {
        this.f2875a = bvVar;
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
        this.f2875a.f2874a.f2868c = new al(c0672a);
        this.f2875a.f2874a.m4097c();
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
    }

    public void onAccountLogoff(C0672a c0672a) {
        if (this.f2875a.f2874a.f2868c.m3367c()) {
            new bx(this, aq.f2771a, this.f2875a.f2874a.f2868c).open();
        }
        this.f2875a.f2874a.f2868c = al.f2359g;
        this.f2875a.f2874a.f2870e = true;
        this.f2875a.f2874a.f2871f = System.currentTimeMillis();
        this.f2875a.f2874a.f2869d = new cp();
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }
}

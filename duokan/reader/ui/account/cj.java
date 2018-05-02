package com.duokan.reader.ui.account;

import com.duokan.c.j;

class cj implements Runnable {
    final /* synthetic */ cy a;
    final /* synthetic */ ch b;

    cj(ch chVar, cy cyVar) {
        this.b = chVar;
        this.a = cyVar;
    }

    public void run() {
        this.a.a(this.b.getContext().getResources().getString(j.gen_bitmap_fail));
    }
}

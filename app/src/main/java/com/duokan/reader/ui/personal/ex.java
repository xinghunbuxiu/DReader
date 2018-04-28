package com.duokan.reader.ui.personal;

import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.be;

class ex implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ev f8528a;

    ex(ev evVar) {
        this.f8528a = evVar;
    }

    public void run() {
        be.m10286a(this.f8528a.f8526a.f8523a, C0258j.general__shared__login_failed, 0).show();
    }
}

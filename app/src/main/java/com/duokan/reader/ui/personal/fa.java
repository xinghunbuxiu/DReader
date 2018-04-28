package com.duokan.reader.ui.personal;

import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.be;

class fa implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ez f8532a;

    fa(ez ezVar) {
        this.f8532a = ezVar;
    }

    public void run() {
        be.m10286a(this.f8532a.f8530a.f8523a, C0258j.store__mi_live__check_update_failed, 0).show();
    }
}

package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.af;
import com.duokan.reader.domain.store.C1176a;

class iz implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f8024a;
    /* renamed from: b */
    final /* synthetic */ String f8025b;
    /* renamed from: c */
    final /* synthetic */ af f8026c;
    /* renamed from: d */
    final /* synthetic */ ix f8027d;

    iz(ix ixVar, String str, String str2, af afVar) {
        this.f8027d = ixVar;
        this.f8024a = str;
        this.f8025b = str2;
        this.f8026c = afVar;
    }

    public void run() {
        C1176a.m8695a().m8704a(this.f8024a, true, true, -1, -1, -1, new ja(this));
    }
}

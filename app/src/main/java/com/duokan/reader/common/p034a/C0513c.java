package com.duokan.reader.common.p034a;

import org.apache.http.protocol.HttpService;

/* renamed from: com.duokan.reader.common.a.c */
class C0513c implements Runnable {
    /* renamed from: a */
    final /* synthetic */ HttpService f1741a;
    /* renamed from: b */
    final /* synthetic */ C0512b f1742b;

    C0513c(C0512b c0512b, HttpService httpService) {
        this.f1742b = c0512b;
        this.f1741a = httpService;
    }

    public void run() {
        this.f1742b.m2219a(this.f1741a);
    }
}

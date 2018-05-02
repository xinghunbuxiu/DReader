package com.duokan.reader.common.p034a;

import org.apache.http.HttpStatus;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpService;

/* renamed from: com.duokan.reader.common.a.d */
class C0514d implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C0515e f1743a;
    /* renamed from: b */
    final /* synthetic */ HttpService f1744b;
    /* renamed from: c */
    final /* synthetic */ HttpContext f1745c;
    /* renamed from: d */
    final /* synthetic */ C0512b f1746d;

    C0514d(C0512b c0512b, C0515e c0515e, HttpService httpService, HttpContext httpContext) {
        this.f1746d = c0512b;
        this.f1743a = c0515e;
        this.f1744b = httpService;
        this.f1745c = httpContext;
    }

    public void run() {
        this.f1746d.f1736d.release();
        while (this.f1743a.isOpen()) {
            try {
                this.f1744b.handleRequest(this.f1743a, this.f1745c);
                if (!this.f1743a.m2225a(HttpStatus.SC_OK)) {
                    this.f1743a.close();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.f1743a.isOpen()) {
                    try {
                        this.f1743a.close();
                    } catch (Exception e) {
                    }
                }
            }
        }
        this.f1746d.f1737e.remove(this.f1743a);
    }
}

package com.duokan.reader.common.a;

import org.apache.http.HttpStatus;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpService;

class d implements Runnable {
    final /* synthetic */ e a;
    final /* synthetic */ HttpService b;
    final /* synthetic */ HttpContext c;
    final /* synthetic */ b d;

    d(b bVar, e eVar, HttpService httpService, HttpContext httpContext) {
        this.d = bVar;
        this.a = eVar;
        this.b = httpService;
        this.c = httpContext;
    }

    public void run() {
        this.d.d.release();
        while (this.a.isOpen()) {
            try {
                this.b.handleRequest(this.a, this.c);
                if (!this.a.a(HttpStatus.SC_OK)) {
                    this.a.close();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (this.a.isOpen()) {
                    try {
                        this.a.close();
                    } catch (Exception e) {
                    }
                }
            }
        }
        this.d.e.remove(this.a);
    }
}

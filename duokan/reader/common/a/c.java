package com.duokan.reader.common.a;

import org.apache.http.protocol.HttpService;

class c implements Runnable {
    final /* synthetic */ HttpService a;
    final /* synthetic */ b b;

    c(b bVar, HttpService httpService) {
        this.b = bVar;
        this.a = httpService;
    }

    public void run() {
        this.b.a(this.a);
    }
}

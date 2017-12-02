package com.duokan.reader.domain.audio;

import com.duokan.reader.common.a.b;

import org.apache.http.protocol.HttpRequestHandlerRegistry;
import org.apache.http.protocol.HttpRequestHandlerResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;

public class g {
    private static g b;
    protected b a;
    private boolean c = false;
    private Map d = new HashMap();
    private long e = -1;

    public void a() {
        if (!this.c) {
            this.c = true;
            this.a = new b(9090);
            HttpRequestHandlerResolver httpRequestHandlerRegistry = new HttpRequestHandlerRegistry();
            httpRequestHandlerRegistry.register("*", new i());
            this.a.a(Executors.newScheduledThreadPool(5), null, null, null, httpRequestHandlerRegistry, null, null);
        }
    }

    public void b() {
        if (this.c) {
            this.c = false;
        }
        if (this.a != null) {
            this.a.b();
        }
        this.e = -1;
        this.d.clear();
    }

    public void a(com.duokan.reader.domain.document.b[] bVarArr, long j) {
        if (this.e != j) {
            this.e = j;
            this.d.clear();
        }
        for (com.duokan.reader.domain.document.b bVar : bVarArr) {
            if (!this.d.containsKey(bVar.d())) {
                this.d.put(bVar.d(), bVar.e());
            }
        }
    }

    public static g c() {
        if (b == null) {
            b = new g();
        }
        return b;
    }
}

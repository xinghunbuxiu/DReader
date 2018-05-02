package com.duokan.reader.domain.audio;

import com.duokan.reader.common.p034a.C0512b;
import com.duokan.reader.domain.document.C0930b;
import com.duokan.reader.domain.document.C1012y;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import org.apache.http.protocol.HttpRequestHandlerRegistry;
import org.apache.http.protocol.HttpRequestHandlerResolver;

/* renamed from: com.duokan.reader.domain.audio.g */
public class C0776g {
    /* renamed from: b */
    private static C0776g f2613b;
    /* renamed from: a */
    protected C0512b f2614a;
    /* renamed from: c */
    private boolean f2615c = false;
    /* renamed from: d */
    private Map<String, C1012y> f2616d = new HashMap();
    /* renamed from: e */
    private long f2617e = -1;

    /* renamed from: a */
    public void m3651a() {
        if (!this.f2615c) {
            this.f2615c = true;
            this.f2614a = new C0512b(9090);
            HttpRequestHandlerResolver httpRequestHandlerRegistry = new HttpRequestHandlerRegistry();
            httpRequestHandlerRegistry.register("*", new C0778i());
            this.f2614a.m2223a(Executors.newScheduledThreadPool(5), null, null, null, httpRequestHandlerRegistry, null, null);
        }
    }

    /* renamed from: b */
    public void m3653b() {
        if (this.f2615c) {
            this.f2615c = false;
        }
        if (this.f2614a != null) {
            this.f2614a.m2224b();
        }
        this.f2617e = -1;
        this.f2616d.clear();
    }

    /* renamed from: a */
    public void m3652a(C0930b[] c0930bArr, long j) {
        if (this.f2617e != j) {
            this.f2617e = j;
            this.f2616d.clear();
        }
        for (C0930b c0930b : c0930bArr) {
            if (!this.f2616d.containsKey(c0930b.mo1446d())) {
                this.f2616d.put(c0930b.mo1446d(), c0930b.mo1447e());
            }
        }
    }

    /* renamed from: c */
    public static C0776g m3650c() {
        if (f2613b == null) {
            f2613b = new C0776g();
        }
        return f2613b;
    }
}

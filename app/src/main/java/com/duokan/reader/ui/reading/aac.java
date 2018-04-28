package com.duokan.reader.ui.reading;

import com.duokan.core.diagnostic.C0328a;
import com.duokan.core.diagnostic.LogLevel;
import com.duokan.core.sys.UThread;
import com.duokan.reader.ui.store.C1502o;

class aac implements Runnable {
    /* renamed from: a */
    final /* synthetic */ abd f9313a;
    /* renamed from: b */
    final /* synthetic */ long f9314b;
    /* renamed from: c */
    final /* synthetic */ Runnable f9315c;
    /* renamed from: d */
    final /* synthetic */ String f9316d;
    /* renamed from: e */
    final /* synthetic */ String f9317e;
    /* renamed from: f */
    final /* synthetic */ String f9318f;
    /* renamed from: g */
    final /* synthetic */ String f9319g;
    /* renamed from: h */
    final /* synthetic */ short f9320h;
    /* renamed from: i */
    final /* synthetic */ Runnable f9321i;
    /* renamed from: j */
    final /* synthetic */ aab f9322j;

    aac(aab aab, abd abd, long j, Runnable runnable, String str, String str2, String str3, String str4, short s, Runnable runnable2) {
        this.f9322j = aab;
        this.f9313a = abd;
        this.f9314b = j;
        this.f9315c = runnable;
        this.f9316d = str;
        this.f9317e = str2;
        this.f9318f = str3;
        this.f9319g = str4;
        this.f9320h = s;
        this.f9321i = runnable2;
    }

    public void run() {
        if (!this.f9322j.q) {
            if (this.f9313a.mo2197j(this.f9314b).m862b(Boolean.valueOf(true))) {
                UThread.post(this.f9315c);
                return;
            }
            C0328a.m757c().m749a(LogLevel.EVENT, "autopay", "pay(book: %s(%s), chapter: %s(%d|%s))", this.f9316d, this.f9317e, this.f9318f, Long.valueOf(this.f9314b), this.f9319g);
            C1502o.m15410a().m15432a(this.f9317e, this.f9319g, this.f9320h, new aad(this));
        }
    }
}

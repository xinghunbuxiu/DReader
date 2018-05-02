package com.duokan.reader.common.webservices;

import com.duokan.reader.common.webservices.WebSession.CacheStrategy;

/* renamed from: com.duokan.reader.common.webservices.k */
public class C0659k {
    /* renamed from: a */
    private String f2208a = WebSession.DEFAULT_SEQ_QUEUE;
    /* renamed from: b */
    private boolean f2209b = false;
    /* renamed from: c */
    private CacheStrategy f2210c = CacheStrategy.DISABLE_CACHE;
    /* renamed from: d */
    private CacheStrategy f2211d = CacheStrategy.DISABLE_CACHE;

    /* renamed from: a */
    public C0659k m3096a(String str) {
        this.f2208a = str;
        return this;
    }

    /* renamed from: a */
    public C0659k m3097a(boolean z) {
        this.f2209b = z;
        return this;
    }

    /* renamed from: a */
    public C0659k m3095a(CacheStrategy cacheStrategy) {
        this.f2210c = cacheStrategy;
        return this;
    }

    /* renamed from: b */
    public C0659k m3098b(CacheStrategy cacheStrategy) {
        this.f2211d = cacheStrategy;
        return this;
    }

    /* renamed from: a */
    public C0657i m3094a() {
        return new C0657i(this.f2208a, this.f2209b, this.f2210c, this.f2211d);
    }
}

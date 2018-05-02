package com.duokan.reader.domain.account;

import java.util.Map;

public class cm<T extends C0705g> {
    /* renamed from: a */
    private final String f2469a;
    /* renamed from: b */
    private final String f2470b;
    /* renamed from: c */
    private final T f2471c;

    public cm(String str, String str2, T t) {
        this.f2469a = str;
        this.f2470b = str2;
        this.f2471c = t;
    }

    /* renamed from: a */
    public Map<String, String> m3446a() {
        return UserAccount.m3175a(this.f2469a, this.f2470b);
    }

    /* renamed from: b */
    public String m3447b() {
        return this.f2469a;
    }

    /* renamed from: c */
    public String m3448c() {
        return this.f2470b;
    }

    /* renamed from: d */
    public T m3449d() {
        return this.f2471c;
    }

    /* renamed from: e */
    public Map<String, String> m3450e() {
        return UserAccount.m3175a(null, this.f2470b);
    }
}

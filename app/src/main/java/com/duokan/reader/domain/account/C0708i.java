package com.duokan.reader.domain.account;

import java.util.HashMap;

/* renamed from: com.duokan.reader.domain.account.i */
public class C0708i {
    /* renamed from: a */
    private final HashMap<Class, C0704h> f2473a = new HashMap();

    public C0708i() {
        m3474a(MiAccount.class, new bb());
        m3474a(MiGuestAccount.class, new bk());
        m3474a(AnonymousAccount.class, new C0743z());
        m3474a(PersonalAccount.class, new cb());
    }

    /* renamed from: a */
    public <T extends C0672a> C0704h<T> m3475a(Class<T> cls) {
        return (C0704h) this.f2473a.get(cls);
    }

    /* renamed from: a */
    private void m3474a(Class cls, C0704h c0704h) {
        this.f2473a.put(cls, c0704h);
    }
}

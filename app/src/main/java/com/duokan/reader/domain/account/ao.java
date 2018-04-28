package com.duokan.reader.domain.account;

import java.util.HashMap;

public class ao {
    /* renamed from: a */
    private final HashMap<Class, an> f2366a = new HashMap();

    public ao() {
        m3370a(MiAccount.class, new bw());
        m3370a(MiGuestAccount.class, new bq());
        m3370a(UserAccount.class, new cl());
        m3370a(PersonalAccount.class, new cl());
    }

    /* renamed from: a */
    public <T extends am> an<T> m3371a(Class<? extends C0672a> cls) {
        if (this.f2366a.containsKey(cls)) {
            return (an) this.f2366a.get(cls);
        }
        return (an) this.f2366a.get(PersonalAccount.class);
    }

    /* renamed from: a */
    private void m3370a(Class cls, an anVar) {
        this.f2366a.put(cls, anVar);
    }
}

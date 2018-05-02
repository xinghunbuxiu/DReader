package com.duokan.reader.domain.account.p042a;

import com.duokan.reader.domain.account.C0420b;
import com.duokan.reader.domain.account.C0672a;

/* renamed from: com.duokan.reader.domain.account.a.r */
public class C0690r implements C0673p {
    /* renamed from: a */
    private final C0420b f2319a;
    /* renamed from: b */
    private final C0672a f2320b;

    public C0690r(C0672a c0672a, C0420b c0420b) {
        this.f2319a = c0420b;
        this.f2320b = c0672a;
    }

    /* renamed from: a */
    public void mo854a() {
        if (this.f2319a != null) {
            this.f2319a.onLoginOk(this.f2320b);
        }
    }
}

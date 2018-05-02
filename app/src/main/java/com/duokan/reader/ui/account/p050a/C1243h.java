package com.duokan.reader.ui.account.p050a;

/* renamed from: com.duokan.reader.ui.account.a.h */
public class C1243h {
    /* renamed from: a */
    private final int f5763a;
    /* renamed from: b */
    private final boolean f5764b;

    public C1243h(int i, boolean z) {
        this.f5763a = i;
        this.f5764b = z;
    }

    /* renamed from: a */
    public boolean m8837a() {
        return this.f5763a == 1;
    }

    /* renamed from: b */
    public boolean m8838b() {
        if (m8837a()) {
            return this.f5764b;
        }
        throw new IllegalStateException();
    }
}

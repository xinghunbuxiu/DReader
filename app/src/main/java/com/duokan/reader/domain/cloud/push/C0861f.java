package com.duokan.reader.domain.cloud.push;

import java.util.Comparator;

/* renamed from: com.duokan.reader.domain.cloud.push.f */
class C0861f implements Comparator<C0876u> {
    /* renamed from: a */
    final /* synthetic */ C0857b f4121a;

    C0861f(C0857b c0857b) {
        this.f4121a = c0857b;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m5693a((C0876u) obj, (C0876u) obj2);
    }

    /* renamed from: a */
    public int m5693a(C0876u c0876u, C0876u c0876u2) {
        if (c0876u.m5733a() > c0876u2.m5733a()) {
            return -1;
        }
        if (c0876u.m5733a() < c0876u2.m5733a()) {
            return 1;
        }
        return 0;
    }
}

package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.domain.social.message.C1151k;
import com.duokan.reader.domain.social.message.as;

/* renamed from: com.duokan.reader.domain.cloud.push.j */
class C0865j implements as {
    /* renamed from: a */
    final /* synthetic */ long f4126a;
    /* renamed from: b */
    final /* synthetic */ C0879x f4127b;
    /* renamed from: c */
    final /* synthetic */ C0857b f4128c;

    C0865j(C0857b c0857b, long j, C0879x c0879x) {
        this.f4128c = c0857b;
        this.f4126a = j;
        this.f4127b = c0879x;
    }

    /* renamed from: a */
    public void mo1180a(C1151k[] c1151kArr, boolean z) {
        this.f4128c.m5650a(this.f4126a, c1151kArr, z, this.f4127b);
    }

    /* renamed from: a */
    public void mo1179a(C1151k[] c1151kArr, String str) {
        this.f4128c.m5650a(this.f4126a, c1151kArr, false, this.f4127b);
    }
}

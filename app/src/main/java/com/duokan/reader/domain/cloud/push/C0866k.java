package com.duokan.reader.domain.cloud.push;

import com.duokan.reader.domain.social.message.ar;
import java.util.List;

/* renamed from: com.duokan.reader.domain.cloud.push.k */
class C0866k implements ar {
    /* renamed from: a */
    final /* synthetic */ List f4129a;
    /* renamed from: b */
    final /* synthetic */ ar f4130b;
    /* renamed from: c */
    final /* synthetic */ C0857b f4131c;

    C0866k(C0857b c0857b, List list, ar arVar) {
        this.f4131c = c0857b;
        this.f4129a = list;
        this.f4130b = arVar;
    }

    /* renamed from: a */
    public void mo1181a() {
        C0872q.m5709b().m5714a(this.f4129a);
        if (this.f4130b != null) {
            this.f4130b.mo1181a();
        }
    }

    /* renamed from: a */
    public void mo1182a(String str) {
        if (this.f4130b != null) {
            this.f4130b.mo1182a(str);
        }
    }
}

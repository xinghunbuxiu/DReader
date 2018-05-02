package com.duokan.reader.domain.plugins.dict;

/* renamed from: com.duokan.reader.domain.plugins.dict.m */
class C1118m implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f5413a;
    /* renamed from: b */
    final /* synthetic */ C1123r f5414b;
    /* renamed from: c */
    final /* synthetic */ C1115j f5415c;

    C1118m(C1115j c1115j, String str, C1123r c1123r) {
        this.f5415c = c1115j;
        this.f5413a = str;
        this.f5414b = c1123r;
    }

    public void run() {
        try {
            if (this.f5415c.f5408d != null) {
                this.f5415c.f5408d.startSearchWord(this.f5413a.trim().toLowerCase(), 2, new C1120o(this.f5415c, this.f5414b));
            } else {
                this.f5414b.mo2221a(new C1124s());
            }
        } catch (Throwable th) {
        }
    }
}

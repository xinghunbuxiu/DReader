package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.async.p035a.C0517a;

class bf implements C0517a {
    /* renamed from: a */
    final /* synthetic */ be f2814a;

    bf(be beVar) {
        this.f2814a = beVar;
    }

    /* renamed from: a */
    public void mo730a(Object obj) {
        if (!this.f2814a.f2808a.isCancelled()) {
            this.f2814a.f2813f.m3970d(this.f2814a.f2809b, this.f2814a.f2810c, this.f2814a.f2811d, this.f2814a.f2812e, this.f2814a.f2808a);
        }
    }

    /* renamed from: a */
    public void mo729a(int i, String str) {
        if (!this.f2814a.f2808a.isCancelled()) {
            this.f2814a.f2813f.m3933i(str);
        }
    }
}

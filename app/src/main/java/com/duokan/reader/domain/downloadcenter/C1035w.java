package com.duokan.reader.domain.downloadcenter;

/* renamed from: com.duokan.reader.domain.downloadcenter.w */
class C1035w implements Runnable {
    /* renamed from: a */
    final /* synthetic */ C1028p f5117a;
    /* renamed from: b */
    final /* synthetic */ C1030r f5118b;

    C1035w(C1030r c1030r, C1028p c1028p) {
        this.f5118b = c1030r;
        this.f5117a = c1028p;
    }

    public void run() {
        if (!this.f5118b.f5106f.contains(this.f5117a)) {
            this.f5117a.m7923i();
        }
    }
}

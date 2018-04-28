package com.duokan.reader.domain.bookshelf;

class fy implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ey f3210a;
    /* renamed from: b */
    final /* synthetic */ fp f3211b;

    fy(fp fpVar, ey eyVar) {
        this.f3211b = fpVar;
        this.f3210a = eyVar;
    }

    public void run() {
        if (this.f3210a.f3148c != null) {
            this.f3210a.f3148c.run(this.f3210a.f3147b);
        }
    }
}

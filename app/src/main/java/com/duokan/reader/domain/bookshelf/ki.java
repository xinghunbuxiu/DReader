package com.duokan.reader.domain.bookshelf;

class ki implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ey f3461a;
    /* renamed from: b */
    final /* synthetic */ kh f3462b;

    ki(kh khVar, ey eyVar) {
        this.f3462b = khVar;
        this.f3461a = eyVar;
    }

    public void run() {
        if (this.f3461a.f3148c != null) {
            this.f3461a.f3148c.run(this.f3461a.f3147b);
        }
    }
}

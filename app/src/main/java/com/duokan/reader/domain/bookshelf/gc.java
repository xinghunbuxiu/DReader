package com.duokan.reader.domain.bookshelf;

class gc implements Runnable {
    /* renamed from: a */
    final /* synthetic */ gb f3219a;

    gc(gb gbVar) {
        this.f3219a = gbVar;
    }

    public void run() {
        if (this.f3219a.f3218a.f3217b.f3212a.f3148c != null) {
            this.f3219a.f3218a.f3217b.f3212a.f3148c.run(this.f3219a.f3218a.f3217b.f3212a.f3147b);
        }
    }
}

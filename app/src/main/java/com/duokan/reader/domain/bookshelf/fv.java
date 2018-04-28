package com.duokan.reader.domain.bookshelf;

import java.util.HashMap;

class fv implements Runnable {
    /* renamed from: a */
    final /* synthetic */ HashMap f3203a;
    /* renamed from: b */
    final /* synthetic */ fu f3204b;

    fv(fu fuVar, HashMap hashMap) {
        this.f3204b = fuVar;
        this.f3203a = hashMap;
    }

    public void run() {
        if (this.f3204b.f3201b != null) {
            this.f3204b.f3201b.run(this.f3203a);
        }
    }
}

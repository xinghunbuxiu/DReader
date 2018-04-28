package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;

class ku implements ag<Integer> {
    /* renamed from: a */
    final /* synthetic */ ag f3482a;
    /* renamed from: b */
    final /* synthetic */ kh f3483b;

    ku(kh khVar, ag agVar) {
        this.f3483b = khVar;
        this.f3482a = agVar;
    }

    public /* synthetic */ void run(Object obj) {
        m4859a((Integer) obj);
    }

    /* renamed from: a */
    public void m4859a(Integer num) {
        this.f3483b.bs();
        if (this.f3482a != null) {
            this.f3482a.run(num);
        }
    }
}

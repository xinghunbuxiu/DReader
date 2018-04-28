package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;

class fr implements ag<Integer> {
    /* renamed from: a */
    final /* synthetic */ ag f3195a;
    /* renamed from: b */
    final /* synthetic */ fp f3196b;

    fr(fp fpVar, ag agVar) {
        this.f3196b = fpVar;
        this.f3195a = agVar;
    }

    public /* synthetic */ void run(Object obj) {
        m4501a((Integer) obj);
    }

    /* renamed from: a */
    public void m4501a(Integer num) {
        this.f3196b.bs();
        if (this.f3195a != null) {
            this.f3195a.run(num);
        }
    }
}

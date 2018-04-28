package com.duokan.reader.domain.bookshelf;

import com.duokan.core.sys.ag;

class fs implements ag<Integer> {
    /* renamed from: a */
    final /* synthetic */ ag f3197a;
    /* renamed from: b */
    final /* synthetic */ fp f3198b;

    fs(fp fpVar, ag agVar) {
        this.f3198b = fpVar;
        this.f3197a = agVar;
    }

    public /* synthetic */ void run(Object obj) {
        m4502a((Integer) obj);
    }

    /* renamed from: a */
    public void m4502a(Integer num) {
        this.f3198b.bx();
        if (this.f3197a != null) {
            this.f3197a.run(num);
        }
    }
}

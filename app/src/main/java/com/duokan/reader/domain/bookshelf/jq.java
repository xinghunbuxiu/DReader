package com.duokan.reader.domain.bookshelf;

import com.duokan.reader.common.async.work.C0537r;
import java.util.Iterator;

class jq implements C0537r {
    /* renamed from: a */
    final /* synthetic */ jp f3411a;

    jq(jp jpVar) {
        this.f3411a = jpVar;
    }

    /* renamed from: a */
    public void mo948a() {
        Iterator it = this.f3411a.f3408e.f3361e.iterator();
        while (it.hasNext()) {
            ((C0537r) it.next()).mo948a();
        }
    }
}

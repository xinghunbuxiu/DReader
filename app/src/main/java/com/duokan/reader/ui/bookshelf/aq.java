package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import java.util.ArrayList;
import java.util.List;

class aq implements ag<aa> {
    /* renamed from: a */
    final /* synthetic */ ao f6140a;

    aq(ao aoVar) {
        this.f6140a = aoVar;
    }

    public /* synthetic */ void run(Object obj) {
        m9183a((aa) obj);
    }

    /* renamed from: a */
    public void m9183a(aa aaVar) {
        List<an> c = this.f6140a.f6121a.mo1658c();
        ArrayList arrayList = new ArrayList(c.size());
        for (an anVar : c) {
            if (anVar instanceof C0800c) {
                arrayList.add((C0800c) anVar);
            }
        }
        ai.m3980a().m3899a((C0800c[]) arrayList.toArray(new C0800c[0]), aaVar);
        this.f6140a.requestDetach();
    }
}

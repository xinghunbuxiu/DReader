package com.duokan.reader.ui.bookshelf;

import com.duokan.core.sys.ag;
import com.duokan.reader.domain.bookshelf.aa;
import com.duokan.reader.domain.bookshelf.ai;
import com.duokan.reader.domain.bookshelf.an;
import com.duokan.reader.domain.bookshelf.c;

import java.util.ArrayList;
import java.util.List;

class ak implements ag {
    final /* synthetic */ ai a;

    ak(ai aiVar) {
        this.a = aiVar;
    }

    public void a(aa aaVar) {
        List<an> c = this.a.a.c();
        ArrayList arrayList = new ArrayList(c.size());
        for (an anVar : c) {
            if (anVar instanceof c) {
                arrayList.add((c) anVar);
            }
        }
        ai.a().a((c[]) arrayList.toArray(new c[0]), aaVar);
        this.a.requestDetach();
    }
}

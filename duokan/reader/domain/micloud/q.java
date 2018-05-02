package com.duokan.reader.domain.micloud;

import com.duokan.reader.common.async.work.c;
import com.duokan.reader.common.async.work.i;

import java.util.LinkedList;
import java.util.List;

class q extends i {
    final /* synthetic */ o a;

    q(o oVar) {
        this.a = oVar;
    }

    public /* synthetic */ void e(c cVar) {
        a((bl) cVar);
    }

    public void a(bl blVar) {
        List<t> linkedList = new LinkedList();
        synchronized (this.a) {
            linkedList.addAll(this.a.c);
        }
        for (t b : linkedList) {
            b.b(this.a);
        }
    }
}

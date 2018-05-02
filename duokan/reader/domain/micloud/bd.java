package com.duokan.reader.domain.micloud;

import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import com.duokan.reader.common.async.work.c;
import com.duokan.reader.common.async.work.j;

import java.util.HashSet;

class bd extends j {
    final /* synthetic */ ba a;
    private HashSet b = new HashSet();

    bd(ba baVar, IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        this.a = baVar;
        super(iAsyncWorkProgressListener);
    }

    public /* synthetic */ void c(c cVar) {
        a((n) cVar);
    }

    public void a(n nVar) {
        for (bi biVar : nVar.y()) {
            if (!this.b.contains(biVar.d())) {
                this.a.m.b(biVar);
                this.b.add(biVar.d());
            }
        }
        super.c(nVar);
    }
}

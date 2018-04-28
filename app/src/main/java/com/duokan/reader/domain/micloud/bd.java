package com.duokan.reader.domain.micloud;

import com.duokan.reader.common.async.work.C0523c;
import com.duokan.reader.common.async.work.C0532j;
import com.duokan.reader.common.async.work.IAsyncWorkProgressListener;
import java.util.HashSet;

class bd extends C0532j<C1073n, C1073n> {
    /* renamed from: a */
    final /* synthetic */ ba f5229a;
    /* renamed from: b */
    private HashSet<String> f5230b = new HashSet();

    bd(ba baVar, IAsyncWorkProgressListener iAsyncWorkProgressListener) {
        this.f5229a = baVar;
        super(iAsyncWorkProgressListener);
    }

    /* renamed from: c */
    public /* synthetic */ void mo747c(C0523c c0523c) {
        m8135a((C1073n) c0523c);
    }

    /* renamed from: a */
    public void m8135a(C1073n c1073n) {
        for (bi biVar : c1073n.m8255y()) {
            if (!this.f5230b.contains(biVar.m8154d())) {
                this.f5229a.f5226m.m8263b(biVar);
                this.f5230b.add(biVar.m8154d());
            }
        }
        super.mo747c(c1073n);
    }
}

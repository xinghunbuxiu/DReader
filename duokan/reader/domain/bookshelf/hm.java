package com.duokan.reader.domain.bookshelf;

import com.duokan.core.c.IRunTask;

class hm implements IRunTask {
    final /* synthetic */ hi a;

    hm(hi hiVar) {
        this.a = hiVar;
    }

    public boolean a(c cVar) {
        return cVar.ao() != -1 && cVar.i() == BookState.CLOUD_ONLY;
    }
}

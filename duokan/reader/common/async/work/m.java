package com.duokan.reader.common.async.work;

import com.duokan.core.c.IRunTask;

class m implements IRunTask {
    final /* synthetic */ String a;
    final /* synthetic */ k b;

    m(k kVar, String str) {
        this.b = kVar;
        this.a = str;
    }

    public boolean a(c cVar) {
        return cVar.b().equals(this.a);
    }
}

package com.duokan.reader.domain.micloud;

import com.duokan.core.c.IRunTask;

class k implements IRunTask {
    final /* synthetic */ String a;
    final /* synthetic */ j b;

    k(j jVar, String str) {
        this.b = jVar;
        this.a = str;
    }

    public boolean a(i iVar) {
        return iVar.w().equals(this.a);
    }
}

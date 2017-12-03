package com.duokan.reader.domain.micloud;

import com.duokan.core.c.IRunTask;

class r implements IRunTask {
    final /* synthetic */ String a;
    final /* synthetic */ o b;

    r(o oVar, String str) {
        this.b = oVar;
        this.a = str;
    }

    public boolean a(bl blVar) {
        return blVar.w().equalsIgnoreCase(this.a);
    }
}

package com.duokan.reader.domain.account;

import com.duokan.core.a.n;
import com.duokan.core.diagnostic.WebLog;
import com.duokan.core.sys.TaskHandler;

class j implements e {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public void a(WebLog aVar) {
        a.c().b(TaskHandler.isCurrentThread());
        synchronized (this.a) {
            this.a.i.put(aVar.getClass(), aVar);
        }
    }

    public void b(WebLog aVar) {
        a.c().b(TaskHandler.isCurrentThread());
        this.a.c(aVar);
    }

    public void c(WebLog aVar) {
        this.a.d(aVar);
    }

    public n a() {
        return this.a.e;
    }

    public n b() {
        return this.a.f;
    }

    public String a(int i) {
        return this.a.c.getString(i);
    }

    public WebLog a(Class cls) {
        return this.a.b(cls);
    }
}

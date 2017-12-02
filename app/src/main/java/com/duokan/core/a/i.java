package com.duokan.core.a;

import java.util.concurrent.Callable;

class i implements Callable {
    final /* synthetic */ l a;
    final /* synthetic */ a b;

    i(a aVar, l lVar) {
        this.b = aVar;
        this.a = lVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public Boolean a() {
        try {
            return Boolean.valueOf(this.a.a(this.b.b));
        } catch (Throwable th) {
            return Boolean.valueOf(false);
        }
    }
}

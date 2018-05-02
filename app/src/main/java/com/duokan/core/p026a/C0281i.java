package com.duokan.core.p026a;

import java.util.concurrent.Callable;


class C0281i implements Callable<Boolean> {
    
    final  C0273l f471a;
    
    final  C0272a f472b;

    C0281i(C0272a c0272a, C0273l c0273l) {
        this.f472b = c0272a;
        this.f471a = c0273l;
    }

    public  Object call() {
        return m648a();
    }

    
    public Boolean m648a() {
        try {
            return Boolean.valueOf(this.f471a.mo379a(this.f472b.f459b));
        } catch (Throwable th) {
            return Boolean.valueOf(false);
        }
    }
}

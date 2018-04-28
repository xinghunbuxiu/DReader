package com.duokan.reader.ui.general.web;

import java.util.concurrent.Callable;

class fz implements Callable<String> {
    /* renamed from: a */
    final /* synthetic */ String f7872a;
    /* renamed from: b */
    final /* synthetic */ ci f7873b;

    fz(ci ciVar, String str) {
        this.f7873b = ciVar;
        this.f7872a = str;
    }

    public /* synthetic */ Object call() {
        return m11136a();
    }

    /* renamed from: a */
    public String m11136a() {
        String str = (String) lj.sParcelMap.get(this.f7872a);
        lj.sParcelMap.remove(this.f7872a);
        return str;
    }
}

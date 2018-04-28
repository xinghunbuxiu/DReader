package com.duokan.reader.ui.general.web;

import com.duokan.reader.DkPublic;
import java.util.concurrent.Callable;

class iq implements Callable<Boolean> {
    /* renamed from: a */
    final /* synthetic */ ci f8009a;

    iq(ci ciVar) {
        this.f8009a = ciVar;
    }

    public /* synthetic */ Object call() {
        return m11202a();
    }

    /* renamed from: a */
    public Boolean m11202a() {
        return Boolean.valueOf(DkPublic.isMiui());
    }
}

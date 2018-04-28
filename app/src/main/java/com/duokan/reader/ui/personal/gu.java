package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import java.util.concurrent.Callable;

class gu implements Callable<ActivatedController> {
    /* renamed from: a */
    final /* synthetic */ gs f8622a;

    gu(gs gsVar) {
        this.f8622a = gsVar;
    }

    public /* synthetic */ Object call() {
        return m11939a();
    }

    /* renamed from: a */
    public ActivatedController m11939a() {
        return new mv(this.f8622a.f8620a.getContext());
    }
}

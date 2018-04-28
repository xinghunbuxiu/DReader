package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.ui.general.web.StorePageController;
import java.util.concurrent.Callable;

class gt implements Callable<ActivatedController> {
    /* renamed from: a */
    final /* synthetic */ gs f8621a;

    gt(gs gsVar) {
        this.f8621a = gsVar;
    }

    public /* synthetic */ Object call() {
        return m11938a();
    }

    /* renamed from: a */
    public ActivatedController m11938a() {
        ActivatedController storePageController = new StorePageController(this.f8621a.f8620a.getContext());
        storePageController.loadUrl(C0641o.m2934i().m2944H());
        return storePageController;
    }
}

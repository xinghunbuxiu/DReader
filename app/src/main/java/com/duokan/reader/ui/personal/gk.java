package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.ui.general.web.StorePageController;
import java.util.concurrent.Callable;

class gk implements Callable<ActivatedController> {
    /* renamed from: a */
    final /* synthetic */ gj f8612a;

    gk(gj gjVar) {
        this.f8612a = gjVar;
    }

    public /* synthetic */ Object call() {
        return m11933a();
    }

    /* renamed from: a */
    public ActivatedController m11933a() {
        ActivatedController storePageController = new StorePageController(this.f8612a.f8611a.getContext());
        storePageController.loadUrl(C0641o.m2934i().m2945I());
        return storePageController;
    }
}

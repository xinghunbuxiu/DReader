package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.ui.general.web.StorePageController;
import java.util.concurrent.Callable;

class gc implements Callable<ActivatedController> {
    /* renamed from: a */
    final /* synthetic */ gb f8604a;

    gc(gb gbVar) {
        this.f8604a = gbVar;
    }

    public /* synthetic */ Object call() {
        return m11929a();
    }

    /* renamed from: a */
    public ActivatedController m11929a() {
        ActivatedController createWebPage = StorePageController.createWebPage(this.f8604a.f8603a.getContext());
        createWebPage.loadUrl(C0641o.m2934i().m2937A());
        return createWebPage;
    }
}

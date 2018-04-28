package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.ui.general.web.StorePageController;
import java.util.concurrent.Callable;

class ge implements Callable<ActivatedController> {
    /* renamed from: a */
    final /* synthetic */ gd f8606a;

    ge(gd gdVar) {
        this.f8606a = gdVar;
    }

    public /* synthetic */ Object call() {
        return m11930a();
    }

    /* renamed from: a */
    public ActivatedController m11930a() {
        ActivatedController createWebPage = StorePageController.createWebPage(this.f8606a.f8605a.getContext());
        createWebPage.loadUrl(C0641o.m2934i().m2938B());
        return createWebPage;
    }
}

package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.ui.general.web.StorePageController;
import java.util.concurrent.Callable;

class gg implements Callable<ActivatedController> {
    /* renamed from: a */
    final /* synthetic */ gf f8608a;

    gg(gf gfVar) {
        this.f8608a = gfVar;
    }

    public /* synthetic */ Object call() {
        return m11931a();
    }

    /* renamed from: a */
    public ActivatedController m11931a() {
        ActivatedController createWebPage = StorePageController.createWebPage(this.f8608a.f8607a.getContext());
        createWebPage.loadUrl(C0641o.m2934i().m2939C());
        return createWebPage;
    }
}

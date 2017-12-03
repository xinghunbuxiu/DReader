package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.web.StorePageController;

import java.util.concurrent.Callable;

class fq implements Callable {
    final /* synthetic */ fp a;

    fq(fp fpVar) {
        this.a = fpVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public ActivatedController a() {
        ActivatedController createWebPage = StorePageController.createWebPage(this.a.a.getContext());
        createWebPage.loadUrl(p.i().B());
        return createWebPage;
    }
}

package com.duokan.reader.ui.personal;

import com.duokan.core.app.e;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.web.StorePageController;

import java.util.concurrent.Callable;

class fs implements Callable {
    final /* synthetic */ fr a;

    fs(fr frVar) {
        this.a = frVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public e a() {
        e createWebPage = StorePageController.createWebPage(this.a.a.getContext());
        createWebPage.loadUrl(p.i().C());
        return createWebPage;
    }
}

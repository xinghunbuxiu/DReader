package com.duokan.reader.ui.personal;

import com.duokan.core.app.e;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.web.StorePageController;

import java.util.concurrent.Callable;

class gg implements Callable {
    final /* synthetic */ gf a;

    gg(gf gfVar) {
        this.a = gfVar;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public e a() {
        e storePageController = new StorePageController(this.a.a.getContext());
        storePageController.loadUrl(p.i().I());
        return storePageController;
    }
}

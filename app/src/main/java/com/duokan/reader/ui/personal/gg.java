package com.duokan.reader.ui.personal;

import com.duokan.core.app.ActivatedController;
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

    public ActivatedController a() {
        ActivatedController storePageController = new StorePageController(this.a.a.getContext());
        storePageController.loadUrl(p.i().I());
        return storePageController;
    }
}

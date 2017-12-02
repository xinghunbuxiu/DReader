package com.duokan.reader.ui.reading;

import com.duokan.core.app.e;
import com.duokan.core.app.x;
import com.duokan.core.sys.ag;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.web.StorePageController;

class dg implements ag {
    final /* synthetic */ df a;

    dg(df dfVar) {
        this.a = dfVar;
    }

    public void a(String str) {
        e storePageController = new StorePageController(x.a(this.a.a.getContext()));
        storePageController.loadUrl(p.i().i(str));
        this.a.a.A.pushHalfPageSmoothly(storePageController, null);
    }
}

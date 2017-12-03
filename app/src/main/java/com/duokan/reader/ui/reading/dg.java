package com.duokan.reader.ui.reading;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.sys.ag;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.web.StorePageController;

class dg implements ag {
    final /* synthetic */ df a;

    dg(df dfVar) {
        this.a = dfVar;
    }

    public void a(String str) {
        ActivatedController storePageController = new StorePageController(MyContextWrapper.getFeature(this.a.a.getContext()));
        storePageController.loadUrl(p.i().i(str));
        this.a.a.A.pushHalfPageSmoothly(storePageController, null);
    }
}

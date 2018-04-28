package com.duokan.reader.ui.reading;

import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.ag;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.ui.general.web.StorePageController;

class di implements ag<String> {
    /* renamed from: a */
    final /* synthetic */ dh f10027a;

    di(dh dhVar) {
        this.f10027a = dhVar;
    }

    public /* synthetic */ void run(Object obj) {
        m13993a((String) obj);
    }

    /* renamed from: a */
    public void m13993a(String str) {
        ActivatedController storePageController = new StorePageController(AppContext.getAppContext(this.f10027a.f10026a.getContext()));
        storePageController.loadUrl(C0641o.m2934i().m2980i(str));
        this.f10027a.f10026a.f9993B.pushHalfPageSmoothly(storePageController, null);
    }
}

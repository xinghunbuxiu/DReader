package com.duokan.reader.ui.reading;

import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.ag;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.general.web.StorePageController;

class cd implements ag<String> {
    /* renamed from: a */
    final /* synthetic */ cc f9930a;

    cd(cc ccVar) {
        this.f9930a = ccVar;
    }

    public /* synthetic */ void run(Object obj) {
        m13846a((String) obj);
    }

    /* renamed from: a */
    public void m13846a(String str) {
        ActivatedController storePageController = new StorePageController(AppContext.getAppContext(this.f9930a.f9929a.f9928a.f9927a.getContext()));
        storePageController.loadUrl(C0641o.m2934i().m2975f(str, null));
        C1163a.m8627k().m8648a("tip", "click", "reading_menu_tip_entrance", true);
        ((ReaderFeature) this.f9930a.f9929a.f9928a.f9927a.getContext().queryFeature(ReaderFeature.class)).showPopupSmoothly(storePageController, null);
    }
}

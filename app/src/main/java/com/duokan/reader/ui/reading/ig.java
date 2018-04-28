package com.duokan.reader.ui.reading;

import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.ag;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.general.web.StorePageController;

class ig implements ag<String> {
    /* renamed from: a */
    final /* synthetic */ C1458if f10385a;

    ig(C1458if c1458if) {
        this.f10385a = c1458if;
    }

    public /* synthetic */ void run(Object obj) {
        m14438a((String) obj);
    }

    /* renamed from: a */
    public void m14438a(String str) {
        ActivatedController storePageController = new StorePageController(AppContext.getAppContext(this.f10385a.f10384a.f10383a.f10382a.getContext()));
        storePageController.loadUrl(C0641o.m2934i().m2975f(str, null));
        C1163a.m8627k().m8648a("tip", "click", "reading_menu_tip_entrance", true);
        ((ReaderFeature) this.f10385a.f10384a.f10383a.f10382a.getContext().queryFeature(ReaderFeature.class)).showPopupSmoothly(storePageController, null);
    }
}

package com.duokan.reader.ui.reading;

import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.ag;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ui.general.ik;
import com.duokan.reader.ui.general.web.StorePageController;

class ed implements ag<String> {
    /* renamed from: a */
    final /* synthetic */ ec f10068a;

    ed(ec ecVar) {
        this.f10068a = ecVar;
    }

    public /* synthetic */ void run(Object obj) {
        m13998a((String) obj);
    }

    /* renamed from: a */
    public void m13998a(String str) {
        ActivatedController ikVar = new ik(AppContext.getAppContext(this.f10068a.f10067a.getContext()));
        ActivatedController storePageController = new StorePageController(AppContext.getAppContext(this.f10068a.f10067a.getContext()));
        storePageController.setHasTitle(false);
        ActivatedController storePageController2 = new StorePageController(AppContext.getAppContext(this.f10068a.f10067a.getContext()));
        storePageController2.setHasTitle(false);
        ikVar.m10793a(storePageController, this.f10068a.f10067a.getResources().getString(C0258j.reading__comment_view__tip_list));
        ikVar.m10793a(storePageController2, this.f10068a.f10067a.getResources().getString(C0258j.reading__comment_view__tip_rank));
        this.f10068a.f10067a.f9993B.pushHalfPageSmoothly(ikVar, null);
    }
}

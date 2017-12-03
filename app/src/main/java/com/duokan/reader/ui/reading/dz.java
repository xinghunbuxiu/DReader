package com.duokan.reader.ui.reading;

import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.sys.ag;
import com.duokan.reader.ui.general.ja;
import com.duokan.reader.ui.general.web.StorePageController;

class dz implements ag {
    final /* synthetic */ dy a;

    dz(dy dyVar) {
        this.a = dyVar;
    }

    public void a(String str) {
        ActivatedController jaVar = new ja(MyContextWrapper.getFeature(this.a.a.getContext()));
        ActivatedController storePageController = new StorePageController(MyContextWrapper.getFeature(this.a.a.getContext()));
        storePageController.setHasTitle(false);
        ActivatedController storePageController2 = new StorePageController(MyContextWrapper.getFeature(this.a.a.getContext()));
        storePageController2.setHasTitle(false);
        jaVar.a(storePageController, this.a.a.getResources().getString(j.reading__comment_view__tip_list));
        jaVar.a(storePageController2, this.a.a.getResources().getString(j.reading__comment_view__tip_rank));
        this.a.a.A.pushHalfPageSmoothly(jaVar, null);
    }
}

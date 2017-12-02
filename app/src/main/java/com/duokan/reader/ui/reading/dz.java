package com.duokan.reader.ui.reading;

import com.duokan.c.j;
import com.duokan.core.app.e;
import com.duokan.core.app.x;
import com.duokan.core.sys.ag;
import com.duokan.reader.ui.general.ja;
import com.duokan.reader.ui.general.web.StorePageController;

class dz implements ag {
    final /* synthetic */ dy a;

    dz(dy dyVar) {
        this.a = dyVar;
    }

    public void a(String str) {
        e jaVar = new ja(x.a(this.a.a.getContext()));
        e storePageController = new StorePageController(x.a(this.a.a.getContext()));
        storePageController.setHasTitle(false);
        e storePageController2 = new StorePageController(x.a(this.a.a.getContext()));
        storePageController2.setHasTitle(false);
        jaVar.a(storePageController, this.a.a.getResources().getString(j.reading__comment_view__tip_list));
        jaVar.a(storePageController2, this.a.a.getResources().getString(j.reading__comment_view__tip_rank));
        this.a.a.A.pushHalfPageSmoothly(jaVar, null);
    }
}

package com.duokan.reader.ui.reading;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.core.sys.ag;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.web.StorePageController;

class cb implements ag {
    final /* synthetic */ ca a;

    cb(ca caVar) {
        this.a = caVar;
    }

    public void a(String str) {
        ActivatedController storePageController = new StorePageController(MyContextWrapper.getFeature(this.a.a.a.a.getContext()));
        storePageController.loadUrl(p.i().f(str, null));
        a.k().a("tip", "click", "reading_menu_tip_entrance", true);
        ((ReaderFeature) this.a.a.a.a.getContext().queryFeature(ReaderFeature.class)).showPopupSmoothly(storePageController, null);
    }
}

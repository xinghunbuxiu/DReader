package com.duokan.reader.ui.store.comment;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.web.StorePageController;

public class a {
    public static ActivatedController a(IFeature featrue, int i, String str) {
        ActivatedController storePageController = new StorePageController(featrue);
        if (i == 1 || i == 3) {
            storePageController.loadUrl(p.i().h(str));
        } else {
            storePageController.loadUrl(p.i().j(str));
        }
        return storePageController;
    }

    public static void a(IFeature featrue, String str) {
        new b(str, featrue).open();
    }
}

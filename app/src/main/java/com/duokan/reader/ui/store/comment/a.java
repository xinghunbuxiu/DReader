package com.duokan.reader.ui.store.comment;

import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.web.StorePageController;

public class a {
    public static e a(y yVar, int i, String str) {
        e storePageController = new StorePageController(yVar);
        if (i == 1 || i == 3) {
            storePageController.loadUrl(p.i().h(str));
        } else {
            storePageController.loadUrl(p.i().j(str));
        }
        return storePageController;
    }

    public static void a(y yVar, String str) {
        new b(str, yVar).open();
    }
}

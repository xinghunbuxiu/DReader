package com.duokan.reader.ui.store;

import com.duokan.c.j;
import com.duokan.core.app.e;
import com.duokan.core.app.x;
import com.duokan.core.app.y;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.web.StorePageController;

public abstract class bv {
    public static e a(y yVar, String str, int i, String str2, String str3) {
        e storePageController = new StorePageController(yVar);
        ((StorePageController) storePageController).loadUrl(p.i().a(str, i, str2, str3));
        return storePageController;
    }

    public static void a(y yVar, String str, String str2, String str3, boolean z) {
        ((com.duokan.reader.ui.e) yVar.queryFeature(com.duokan.reader.ui.e.class)).pushPageSmoothly(a(yVar, String.valueOf(0), z ? 1 : 2, str, str3), null);
    }

    public static e a(y yVar) {
        e storePageController = new StorePageController(yVar);
        storePageController.loadUrl(p.i().H());
        return storePageController;
    }

    public static e a(x xVar) {
        e storePageController = new StorePageController(xVar);
        storePageController.loadUrl(p.i().E());
        storePageController.setPageTitle(xVar.getString(j.personal__purchased_book_group_title_view__subscribe));
        return storePageController;
    }

    public static e a(y yVar, String str) {
        e storePageController = new StorePageController(yVar);
        storePageController.loadUrl(p.i().g(str));
        return storePageController;
    }

    public static e b(y yVar) {
        e storePageController = new StorePageController(yVar);
        storePageController.loadUrl(p.i().F());
        return storePageController;
    }

    public static e c(y yVar) {
        e storePageController = new StorePageController(yVar);
        storePageController.loadUrl(p.i().G());
        return storePageController;
    }

    public static e b(x xVar) {
        e storePageController = new StorePageController(xVar);
        storePageController.loadUrl(p.i().b(null));
        return storePageController;
    }

    public static e c(x xVar) {
        e storePageController = new StorePageController(xVar);
        storePageController.loadUrl(p.i().A());
        return storePageController;
    }

    public static e d(x xVar) {
        e storePageController = new StorePageController(xVar);
        storePageController.loadUrl(p.i().B());
        return storePageController;
    }

    public static e e(x xVar) {
        e storePageController = new StorePageController(xVar);
        storePageController.loadUrl(p.i().C());
        return storePageController;
    }
}

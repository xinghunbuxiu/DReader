package com.duokan.reader.ui.store;

import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.ui.general.web.StorePageController;

public abstract class bv {
    public static ActivatedController a(IFeature featrue, String str, int i, String str2, String str3) {
        ActivatedController storePageController = new StorePageController(featrue);
        ((StorePageController) storePageController).loadUrl(p.i().a(str, i, str2, str3));
        return storePageController;
    }

    public static void a(IFeature featrue, String str, String str2, String str3, boolean z) {
        ((com.duokan.reader.ui.e) featrue.queryFeature(com.duokan.reader.ui.e.class)).pushPageSmoothly(a(featrue, String.valueOf(0), z ? 1 : 2, str, str3), null);
    }

    public static ActivatedController a(IFeature featrue) {
        ActivatedController storePageController = new StorePageController(featrue);
        storePageController.loadUrl(p.i().H());
        return storePageController;
    }

    public static ActivatedController a(MyContextWrapper mContext) {
        ActivatedController storePageController = new StorePageController(mContext);
        storePageController.loadUrl(p.i().E());
        storePageController.setPageTitle(mContext.getString(j.personal__purchased_book_group_title_view__subscribe));
        return storePageController;
    }

    public static ActivatedController a(IFeature featrue, String str) {
        ActivatedController storePageController = new StorePageController(featrue);
        storePageController.loadUrl(p.i().g(str));
        return storePageController;
    }

    public static ActivatedController b(IFeature featrue) {
        ActivatedController storePageController = new StorePageController(featrue);
        storePageController.loadUrl(p.i().F());
        return storePageController;
    }

    public static ActivatedController c(IFeature featrue) {
        ActivatedController storePageController = new StorePageController(featrue);
        storePageController.loadUrl(p.i().G());
        return storePageController;
    }

    public static ActivatedController b(MyContextWrapper mContext) {
        ActivatedController storePageController = new StorePageController(mContext);
        storePageController.loadUrl(p.i().b(null));
        return storePageController;
    }

    public static ActivatedController c(MyContextWrapper mContext) {
        ActivatedController storePageController = new StorePageController(mContext);
        storePageController.loadUrl(p.i().A());
        return storePageController;
    }

    public static ActivatedController d(MyContextWrapper mContext) {
        ActivatedController storePageController = new StorePageController(mContext);
        storePageController.loadUrl(p.i().B());
        return storePageController;
    }

    public static ActivatedController e(MyContextWrapper mContext) {
        ActivatedController storePageController = new StorePageController(mContext);
        storePageController.loadUrl(p.i().C());
        return storePageController;
    }
}

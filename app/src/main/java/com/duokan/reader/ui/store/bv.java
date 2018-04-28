package com.duokan.reader.ui.store;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.ui.C0436e;
import com.duokan.reader.ui.general.web.StorePageController;

public abstract class bv {
    /* renamed from: a */
    public static ActivatedController m15355a(IFeature mFeature, String str, int i, String str2, String str3) {
        ActivatedController storePageController = new StorePageController(mFeature);
        ((StorePageController) storePageController).loadUrl(C0641o.m2934i().m2954a(str, i, str2, str3));
        return storePageController;
    }

    /* renamed from: a */
    public static void m15356a(IFeature mFeature, String str, String str2, String str3, boolean z) {
        ((C0436e) mFeature.queryFeature(C0436e.class)).pushPageSmoothly(m15355a(mFeature, String.valueOf(0), z ? 1 : 2, str, str3), null);
    }

    /* renamed from: a */
    public static ActivatedController m15353a(IFeature mFeature) {
        ActivatedController storePageController = new StorePageController(mFeature);
        storePageController.loadUrl(C0641o.m2934i().m2943G());
        return storePageController;
    }

    /* renamed from: a */
    public static ActivatedController m15352a(AppContext appContext) {
        ActivatedController storePageController = new StorePageController(appContext);
        storePageController.loadUrl(C0641o.m2934i().m2940D());
        storePageController.setPageTitle(appContext.getString(C0258j.personal__purchased_book_group_title_view__subscribe));
        return storePageController;
    }

    /* renamed from: a */
    public static ActivatedController m15354a(IFeature mFeature, String str) {
        ActivatedController storePageController = new StorePageController(mFeature);
        storePageController.loadUrl(C0641o.m2934i().m2977g(str));
        return storePageController;
    }

    /* renamed from: b */
    public static ActivatedController m15358b(IFeature mFeature) {
        ActivatedController storePageController = new StorePageController(mFeature);
        storePageController.loadUrl(C0641o.m2934i().m2941E());
        return storePageController;
    }

    /* renamed from: c */
    public static ActivatedController m15360c(IFeature mFeature) {
        ActivatedController storePageController = new StorePageController(mFeature);
        storePageController.loadUrl(C0641o.m2934i().m2942F());
        return storePageController;
    }

    /* renamed from: b */
    public static ActivatedController m15357b(AppContext appContext) {
        ActivatedController storePageController = new StorePageController(appContext);
        storePageController.loadUrl(C0641o.m2934i().m2962b(null));
        return storePageController;
    }

    /* renamed from: c */
    public static ActivatedController m15359c(AppContext appContext) {
        ActivatedController storePageController = new StorePageController(appContext);
        storePageController.loadUrl(C0641o.m2934i().m2937A());
        return storePageController;
    }

    /* renamed from: d */
    public static ActivatedController m15361d(AppContext appContext) {
        ActivatedController storePageController = new StorePageController(appContext);
        storePageController.loadUrl(C0641o.m2934i().m2938B());
        return storePageController;
    }

    /* renamed from: e */
    public static ActivatedController m15362e(AppContext appContext) {
        ActivatedController storePageController = new StorePageController(appContext);
        storePageController.loadUrl(C0641o.m2934i().m2939C());
        return storePageController;
    }
}

package com.duokan.reader.ui.store.comment;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.ui.general.web.StorePageController;

/* renamed from: com.duokan.reader.ui.store.comment.a */
public class C1478a {
    /* renamed from: a */
    public static ActivatedController m15368a(IFeature mFeature, int i, String str) {
        ActivatedController storePageController = new StorePageController(mFeature);
        if (i == 1 || i == 3) {
            storePageController.loadUrl(C0641o.m2934i().m2979h(str));
        } else {
            storePageController.loadUrl(C0641o.m2934i().m2981j(str));
        }
        return storePageController;
    }

    /* renamed from: a */
    public static void m15369a(IFeature mFeature, String str) {
        new C1479b(C0643q.f2173a, str, mFeature).open();
    }
}

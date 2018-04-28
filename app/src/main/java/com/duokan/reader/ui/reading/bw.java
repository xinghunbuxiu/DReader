package com.duokan.reader.ui.reading;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.AppContext;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.account.C0666x;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.ui.general.web.StorePageController;

class bw implements C0666x {
    /* renamed from: a */
    final /* synthetic */ String f9905a;
    /* renamed from: b */
    final /* synthetic */ bn f9906b;

    bw(bn bnVar, String str) {
        this.f9906b = bnVar;
        this.f9905a = str;
    }

    public void onQueryAccountOk(C0672a c0672a) {
        IFeature a = AppContext.getAppContext(this.f9906b.getContext());
        if (a != null) {
            ActivatedController storePageController = new StorePageController(a);
            storePageController.loadUrl(this.f9905a);
            ReaderFeature readerFeature = (ReaderFeature) a.queryFeature(ReaderFeature.class);
            if (readerFeature == null) {
                return;
            }
            if (storePageController.transparent()) {
                readerFeature.showPopup(storePageController);
            } else {
                readerFeature.pushHalfPageSmoothly(storePageController, null);
            }
        }
    }

    public void onQueryAccountError(C0672a c0672a, String str) {
    }
}

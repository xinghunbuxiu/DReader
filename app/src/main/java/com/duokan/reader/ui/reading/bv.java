package com.duokan.reader.ui.reading;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.MyContextWrapper;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.u;
import com.duokan.reader.ui.general.web.StorePageController;

class bv implements u {
    final /* synthetic */ String a;
    final /* synthetic */ bn b;

    bv(bn bnVar, String str) {
        this.b = bnVar;
        this.a = str;
    }

    public void onQueryAccountOk(a aVar) {
        IFeature a = MyContextWrapper.getFeature(this.b.getContext());
        if (a != null) {
            ActivatedController storePageController = new StorePageController(a);
            storePageController.loadUrl(this.a);
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

    public void onQueryAccountError(a aVar, String str) {
    }
}

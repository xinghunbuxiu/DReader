package com.duokan.reader.ui.general.web;

import com.duokan.core.app.IFeature;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.statistics.C1163a;

class WebSceneController$1 extends StorePageController {
    final /* synthetic */ lp this$0;

    WebSceneController$1(lp lpVar, IFeature mFeature) {
        this.this$0 = lpVar;
        super(mFeature);
    }

    protected void webPageLoading(boolean z) {
        super.webPageLoading(z);
        if (!isLoading()) {
            C1163a.m8627k().m8660f();
            DkApp.get().setReadyToSee();
        }
    }
}

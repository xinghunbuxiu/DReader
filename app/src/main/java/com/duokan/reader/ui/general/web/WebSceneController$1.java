package com.duokan.reader.ui.general.web;

import com.duokan.core.app.y;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.statistics.a;

class WebSceneController$1 extends StorePageController {
    final /* synthetic */ kk this$0;

    WebSceneController$1(kk kkVar, y yVar) {
        this.this$0 = kkVar;
        super(yVar);
    }

    protected void webPageLoading(boolean z) {
        super.webPageLoading(z);
        if (!isLoading()) {
            a.k().f();
            DkApp.get().setReadyToSee();
        }
    }
}

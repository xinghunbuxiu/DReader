package com.duokan.reader.ui.store.comment;

import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.duokan.o;
import com.duokan.reader.common.webservices.duokan.p;
import com.duokan.reader.common.webservices.duokan.r;
import com.duokan.reader.ui.general.web.StorePageController;

final class b extends r {
    com.duokan.reader.common.webservices.b a = new com.duokan.reader.common.webservices.b();
    final /* synthetic */ String b;
    final /* synthetic */ y c;

    b(String str, y yVar) {
        this.b = str;
        this.c = yVar;
    }

    protected void onSessionTry() {
        this.a = new o(this, null).g(this.b);
    }

    protected void onSessionSucceeded() {
        e storePageController = new StorePageController(this.c);
        storePageController.loadUrl(p.i().i((String) this.a.a));
        ((ReaderFeature) this.c.queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(storePageController, null);
    }

    protected void onSessionFailed() {
    }
}

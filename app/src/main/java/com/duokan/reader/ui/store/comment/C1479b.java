package com.duokan.reader.ui.store.comment;

import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.reader.ReaderFeature;
import com.duokan.reader.common.webservices.C0621a;
import com.duokan.reader.common.webservices.C0657i;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.common.webservices.duokan.C0640n;
import com.duokan.reader.common.webservices.duokan.C0641o;
import com.duokan.reader.ui.general.web.StorePageController;

/* renamed from: com.duokan.reader.ui.store.comment.b */
final class C1479b extends WebSession {
    /* renamed from: a */
    C0621a<String> f11398a = new C0621a();
    /* renamed from: b */
    final /* synthetic */ String f11399b;
    /* renamed from: c */
    final /* synthetic */ IFeature f11400c;

    C1479b(C0657i c0657i, String str, IFeature mFeature) {
        this.f11399b = str;
        this.f11400c = mFeature;
        super(c0657i);
    }

    protected void onSessionTry() {
        this.f11398a = new C0640n(this, null).m2924g(this.f11399b);
    }

    protected void onSessionSucceeded() {
        ActivatedController storePageController = new StorePageController(this.f11400c);
        storePageController.loadUrl(C0641o.m2934i().m2980i((String) this.f11398a.f2058a));
        ((ReaderFeature) this.f11400c.queryFeature(ReaderFeature.class)).pushHalfPageSmoothly(storePageController, null);
    }

    protected void onSessionFailed() {
    }
}

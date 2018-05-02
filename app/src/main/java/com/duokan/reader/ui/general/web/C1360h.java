package com.duokan.reader.ui.general.web;

import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.p037c.C0563j;
import com.duokan.reader.common.webservices.duokan.C0641o;

/* renamed from: com.duokan.reader.ui.general.web.h */
class C1360h implements C0563j {
    /* renamed from: a */
    final /* synthetic */ DkWebView f7917a;

    C1360h(DkWebView dkWebView) {
        this.f7917a = dkWebView;
    }

    public void onConnectivityChanged(C0559f c0559f) {
        if (!C0641o.m2934i().m2984k()) {
            return;
        }
        if (c0559f.m2486e()) {
            this.f7917a.f7559c.setCacheMode(-1);
        } else {
            this.f7917a.f7559c.setCacheMode(1);
        }
    }
}

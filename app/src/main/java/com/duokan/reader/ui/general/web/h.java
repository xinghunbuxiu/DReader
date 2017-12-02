package com.duokan.reader.ui.general.web;

import com.duokan.reader.common.c.f;
import com.duokan.reader.common.c.g;
import com.duokan.reader.common.webservices.duokan.p;

class h implements g {
    final /* synthetic */ DkWebView a;

    h(DkWebView dkWebView) {
        this.a = dkWebView;
    }

    public void onConnectivityChanged(f fVar) {
        if (!p.i().k()) {
            return;
        }
        if (fVar.e()) {
            this.a.c.setCacheMode(-1);
        } else {
            this.a.c.setCacheMode(1);
        }
    }
}

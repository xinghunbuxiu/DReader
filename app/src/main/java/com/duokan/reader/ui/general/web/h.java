package com.duokan.reader.ui.general.web;

import com.duokan.reader.common.classc;
import com.duokan.reader.common.webservices.duokan.p;

class h implements classc.IConnectChanged {
    final /* synthetic */ DkWebView a;

    h(DkWebView dkWebView) {
        this.a = dkWebView;
    }

    public void onConnectivityChanged(classc.ConnectivityReceiver connectivity) {
        if (!p.i().k()) {
            return;
        }
        if (connectivity.e()) {
            this.a.c.setCacheMode(-1);
        } else {
            this.a.c.setCacheMode(1);
        }
    }
}

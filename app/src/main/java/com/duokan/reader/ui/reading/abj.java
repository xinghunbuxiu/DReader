package com.duokan.reader.ui.reading;

import fi.harism.curl.CurlDirection;

class abj implements Runnable {
    /* renamed from: a */
    final /* synthetic */ CurlDirection f9395a;
    /* renamed from: b */
    final /* synthetic */ abg f9396b;

    abj(abg abg, CurlDirection curlDirection) {
        this.f9396b = abg;
        this.f9395a = curlDirection;
    }

    public void run() {
        if (this.f9395a == CurlDirection.PAGE_DOWN) {
            this.f9396b.f9391a.f9379a.mo2179u();
        } else {
            this.f9396b.f9391a.f9379a.mo2178t();
        }
    }
}

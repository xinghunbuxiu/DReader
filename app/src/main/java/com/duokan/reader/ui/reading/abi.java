package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.C0941i;
import com.duokan.reader.domain.document.as;
import fi.harism.curl.CurlAnchor;
import java.util.concurrent.Callable;

class abi implements Callable<CurlAnchor> {
    /* renamed from: a */
    final /* synthetic */ abg f9394a;

    abi(abg abg) {
        this.f9394a = abg;
    }

    public /* synthetic */ Object call() {
        return m13246a();
    }

    /* renamed from: a */
    public CurlAnchor m13246a() {
        CurlAnchor curlAnchor = new CurlAnchor();
        as h = this.f9394a.f9391a.f9379a.mo2136e(-1).mo2332h();
        if (h instanceof C0941i) {
            curlAnchor.mPageDrawable = ((C0941i) h).mo1305b();
        } else {
            curlAnchor.mPageDrawable = h;
        }
        return curlAnchor;
    }
}

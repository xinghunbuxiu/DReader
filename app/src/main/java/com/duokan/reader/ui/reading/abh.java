package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.C0941i;
import com.duokan.reader.domain.document.as;
import fi.harism.curl.CurlAnchor;
import java.util.concurrent.Callable;

class abh implements Callable<CurlAnchor> {
    /* renamed from: a */
    final /* synthetic */ CurlAnchor f9392a;
    /* renamed from: b */
    final /* synthetic */ abg f9393b;

    abh(abg abg, CurlAnchor curlAnchor) {
        this.f9393b = abg;
        this.f9392a = curlAnchor;
    }

    public /* synthetic */ Object call() {
        return m13245a();
    }

    /* renamed from: a */
    public CurlAnchor m13245a() {
        CurlAnchor curlAnchor = new CurlAnchor();
        as h = this.f9393b.f9391a.f9379a.mo2136e(1).mo2332h();
        if (h instanceof C0941i) {
            curlAnchor.mPageDrawable = ((C0941i) h).mo1305b();
        } else {
            curlAnchor.mPageDrawable = h;
        }
        if (curlAnchor.mPageDrawable == this.f9392a.mPageDrawable) {
            curlAnchor.mPageDrawable = null;
        }
        return curlAnchor;
    }
}

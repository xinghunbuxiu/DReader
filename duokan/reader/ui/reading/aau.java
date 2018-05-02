package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.i;

import java.util.concurrent.Callable;

class aau implements Callable {
    final /* synthetic */ CurlAnchor a;
    final /* synthetic */ aat b;

    aau(aat com_duokan_reader_ui_reading_aat, CurlAnchor curlAnchor) {
        this.b = com_duokan_reader_ui_reading_aat;
        this.a = curlAnchor;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public CurlAnchor a() {
        CurlAnchor curlAnchor = new CurlAnchor();
        as h = this.b.a.a.e(1).h();
        if (h instanceof i) {
            curlAnchor.mPageDrawable = ((i) h).b();
        } else {
            curlAnchor.mPageDrawable = h;
        }
        if (curlAnchor.mPageDrawable == this.a.mPageDrawable) {
            curlAnchor.mPageDrawable = null;
        }
        return curlAnchor;
    }
}

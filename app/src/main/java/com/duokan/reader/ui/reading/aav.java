package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.as;
import com.duokan.reader.domain.document.i;

import java.util.concurrent.Callable;

class aav implements Callable {
    final /* synthetic */ aat a;

    aav(aat com_duokan_reader_ui_reading_aat) {
        this.a = com_duokan_reader_ui_reading_aat;
    }

    public /* synthetic */ Object call() {
        return a();
    }

    public CurlAnchor a() {
        CurlAnchor curlAnchor = new CurlAnchor();
        as h = this.a.a.a.e(-1).h();
        if (h instanceof i) {
            curlAnchor.mPageDrawable = ((i) h).b();
        } else {
            curlAnchor.mPageDrawable = h;
        }
        return curlAnchor;
    }
}

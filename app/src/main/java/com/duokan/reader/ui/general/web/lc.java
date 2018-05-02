package com.duokan.reader.ui.general.web;

import android.webkit.JavascriptInterface;
import com.duokan.reader.ui.general.web.TtsWebController.C13516;

class lc extends ci {
    /* renamed from: a */
    final /* synthetic */ C13516 f8136a;

    lc(C13516 c13516) {
        this.f8136a = c13516;
        super(c13516);
    }

    @JavascriptInterface
    public void updateTtsInfo(String str) {
        m11020b(new ld(this, str));
    }
}

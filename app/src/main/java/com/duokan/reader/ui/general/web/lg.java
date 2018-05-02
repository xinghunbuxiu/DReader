package com.duokan.reader.ui.general.web;

import android.annotation.SuppressLint;
import android.webkit.JavascriptInterface;
import com.duokan.core.sys.C0299i;
import com.duokan.core.sys.UThread;

class lg extends ci {
    /* renamed from: a */
    final /* synthetic */ TtsWebController f8145a;

    private lg(TtsWebController ttsWebController) {
        this.f8145a = ttsWebController;
        super(ttsWebController);
    }

    @JavascriptInterface
    @SuppressLint({"NewApi"})
    public synchronized String jsCall(String str, String str2, String str3, String str4) {
        C0299i c0299i;
        c0299i = new C0299i();
        UThread.runOnThread(new lh(this, str, c0299i, str2, str3));
        return (String) c0299i.m707a();
    }
}

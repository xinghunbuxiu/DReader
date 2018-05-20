package com.duokan.core.ui;

import android.content.Intent;
import android.webkit.WebChromeClient.FileChooserParams;

class fn extends FileChooserParams {
    /* renamed from: a */
    final /* synthetic */ fp f1259a;
    /* renamed from: b */
    final /* synthetic */ WebPageChromeClient f1260b;

    fn(WebPageChromeClient webPageChromeClient, fp fpVar) {
        this.f1260b = webPageChromeClient;
        this.f1259a = fpVar;
    }

    public boolean isCaptureEnabled() {
        return this.f1259a.mo533c();
    }

    public CharSequence getTitle() {
        return this.f1259a.mo534d();
    }

    public int getMode() {
        return this.f1259a.mo531a();
    }

    public String getFilenameHint() {
        return this.f1259a.mo535e();
    }

    public String[] getAcceptTypes() {
        return this.f1259a.mo532b();
    }

    public Intent createIntent() {
        return this.f1259a.mo536f();
    }
}

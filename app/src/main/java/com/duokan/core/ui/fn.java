package com.duokan.core.ui;

import android.content.Intent;
import android.webkit.WebChromeClient.FileChooserParams;

class fn extends FileChooserParams {
    final /* synthetic */ fp a;
    final /* synthetic */ fl b;

    fn(fl flVar, fp fpVar) {
        this.b = flVar;
        this.a = fpVar;
    }

    public boolean isCaptureEnabled() {
        return this.a.c();
    }

    public CharSequence getTitle() {
        return this.a.d();
    }

    public int getMode() {
        return this.a.a();
    }

    public String getFilenameHint() {
        return this.a.e();
    }

    public String[] getAcceptTypes() {
        return this.a.b();
    }

    public Intent createIntent() {
        return this.a.f();
    }
}

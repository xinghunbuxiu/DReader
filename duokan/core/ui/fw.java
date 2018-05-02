package com.duokan.core.ui;

import android.content.Intent;
import android.webkit.WebChromeClient.FileChooserParams;

class fw extends fp {
    final /* synthetic */ FileChooserParams a;
    final /* synthetic */ fu b;

    fw(fu fuVar, FileChooserParams fileChooserParams) {
        this.b = fuVar;
        this.a = fileChooserParams;
    }

    public boolean c() {
        return this.a.isCaptureEnabled();
    }

    public CharSequence d() {
        return this.a.getTitle();
    }

    public int a() {
        return this.a.getMode();
    }

    public String e() {
        return this.a.getFilenameHint();
    }

    public String[] b() {
        return this.a.getAcceptTypes();
    }

    public Intent f() {
        return this.a.createIntent();
    }
}

package com.duokan.core.ui;

import android.content.Intent;
import android.webkit.WebChromeClient.FileChooserParams;

class fy extends fp {
    /* renamed from: a */
    final /* synthetic */ FileChooserParams f1279a;
    /* renamed from: b */
    final /* synthetic */ fw f1280b;

    fy(fw fwVar, FileChooserParams fileChooserParams) {
        this.f1280b = fwVar;
        this.f1279a = fileChooserParams;
    }

    /* renamed from: c */
    public boolean mo533c() {
        return this.f1279a.isCaptureEnabled();
    }

    /* renamed from: d */
    public CharSequence mo534d() {
        return this.f1279a.getTitle();
    }

    /* renamed from: a */
    public int mo531a() {
        return this.f1279a.getMode();
    }

    /* renamed from: e */
    public String mo535e() {
        return this.f1279a.getFilenameHint();
    }

    /* renamed from: b */
    public String[] mo532b() {
        return this.f1279a.getAcceptTypes();
    }

    /* renamed from: f */
    public Intent mo536f() {
        return this.f1279a.createIntent();
    }
}

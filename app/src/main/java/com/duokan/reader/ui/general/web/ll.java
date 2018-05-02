package com.duokan.reader.ui.general.web;

import android.webkit.JsResult;
import com.duokan.p024c.C0258j;

class ll implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f8154a;
    /* renamed from: b */
    final /* synthetic */ boolean f8155b;
    /* renamed from: c */
    final /* synthetic */ JsResult f8156c;
    /* renamed from: d */
    final /* synthetic */ lj f8157d;

    ll(lj ljVar, String str, boolean z, JsResult jsResult) {
        this.f8157d = ljVar;
        this.f8154a = str;
        this.f8155b = z;
        this.f8156c = jsResult;
    }

    public void run() {
        String string;
        lj ljVar = this.f8157d;
        String str = "";
        String str2 = this.f8154a;
        if (this.f8155b) {
            string = this.f8157d.getString(C0258j.general__shared__cancel);
        } else {
            string = null;
        }
        ljVar.js_showDialog(str, str2, null, string, new lm(this), new ln(this));
    }
}

package com.duokan.reader.ui.general.web;

import android.webkit.JsResult;

import com.duokan.c.j;

class kg implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ boolean b;
    final /* synthetic */ JsResult c;
    final /* synthetic */ ke d;

    kg(ke keVar, String str, boolean z, JsResult jsResult) {
        this.d = keVar;
        this.a = str;
        this.b = z;
        this.c = jsResult;
    }

    public void run() {
        String string;
        ke keVar = this.d;
        String str = "";
        String str2 = this.a;
        if (this.b) {
            string = this.d.getString(j.general__shared__cancel);
        } else {
            string = null;
        }
        keVar.js_showDialog(str, str2, null, string, new kh(this), new ki(this));
    }
}

package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.core.sys.t;

class ag implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ ae c;

    ag(ae aeVar, String str, Runnable runnable) {
        this.c = aeVar;
        this.a = str;
        this.b = runnable;
    }

    public void run() {
        if (TextUtils.equals(this.c.a.mEditText.getText(), this.a)) {
            t.a(this.b);
        }
    }
}

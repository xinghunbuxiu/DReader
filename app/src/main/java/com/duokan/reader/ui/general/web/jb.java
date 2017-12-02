package com.duokan.reader.ui.general.web;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.jq;
import com.mipay.sdk.Mipay;

class jb implements Runnable {
    final /* synthetic */ jq a;
    final /* synthetic */ boolean b;
    final /* synthetic */ String c;
    final /* synthetic */ iv d;

    jb(iv ivVar, jq jqVar, boolean z, String str) {
        this.d = ivVar;
        this.a = jqVar;
        this.b = z;
        this.c = str;
    }

    public void run() {
        this.a.dismiss();
        if (this.b) {
            this.d.b.b.web_notifyWeb(this.c, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
            ReaderEnv.get().setAdvancedActionTime(System.currentTimeMillis());
            return;
        }
        this.d.b.b.web_notifyWeb(this.c, 2, new Object[0]);
    }
}

package com.duokan.reader.ui.general.web;

import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.ja;
import com.mipay.sdk.Mipay;

class jo implements Runnable {
    /* renamed from: a */
    final /* synthetic */ ja f8058a;
    /* renamed from: b */
    final /* synthetic */ boolean f8059b;
    /* renamed from: c */
    final /* synthetic */ String f8060c;
    /* renamed from: d */
    final /* synthetic */ ji f8061d;

    jo(ji jiVar, ja jaVar, boolean z, String str) {
        this.f8061d = jiVar;
        this.f8058a = jaVar;
        this.f8059b = z;
        this.f8060c = str;
    }

    public void run() {
        this.f8058a.dismiss();
        if (this.f8059b) {
            this.f8061d.f8048b.f7581b.web_notifyWeb(this.f8060c, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
            ReaderEnv.get().setAdvancedActionTime(System.currentTimeMillis());
            return;
        }
        this.f8061d.f8048b.f7581b.web_notifyWeb(this.f8060c, 2, new Object[0]);
    }
}

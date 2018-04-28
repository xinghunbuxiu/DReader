package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.ja;
import com.mipay.sdk.Mipay;

class jy implements as {
    /* renamed from: a */
    final /* synthetic */ String f8077a;
    /* renamed from: b */
    final /* synthetic */ ja f8078b;
    /* renamed from: c */
    final /* synthetic */ ji f8079c;

    jy(ji jiVar, String str, ja jaVar) {
        this.f8079c = jiVar;
        this.f8077a = str;
        this.f8078b = jaVar;
    }

    /* renamed from: a */
    public void mo1831a() {
        this.f8079c.f8048b.f7581b.web_notifyWeb(this.f8077a, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
        this.f8078b.dismiss();
        ReaderEnv.get().setAdvancedActionTime(System.currentTimeMillis());
    }
}

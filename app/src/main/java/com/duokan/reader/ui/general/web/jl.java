package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.jq;
import com.mipay.sdk.Mipay;

class jl implements as {
    final /* synthetic */ String a;
    final /* synthetic */ jq b;
    final /* synthetic */ iv c;

    jl(iv ivVar, String str, jq jqVar) {
        this.c = ivVar;
        this.a = str;
        this.b = jqVar;
    }

    public void a() {
        this.c.b.b.web_notifyWeb(this.a, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
        this.b.dismiss();
        ReaderEnv.get().setAdvancedActionTime(System.currentTimeMillis());
    }
}

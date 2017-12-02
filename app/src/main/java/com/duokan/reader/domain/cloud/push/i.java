package com.duokan.reader.domain.cloud.push;

import android.text.TextUtils;

import com.duokan.reader.UmengManager;

class i implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ h b;

    i(h hVar, String str) {
        this.b = hVar;
        this.a = str;
    }

    public void run() {
        if (!TextUtils.isEmpty(this.a)) {
            UmengManager.get().onEvent("MIPUSH_V1", "dk_push_success");
        }
        this.b.a.a.f();
    }
}

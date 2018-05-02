package com.duokan.reader.domain.cloud.push;

import android.text.TextUtils;
import com.duokan.reader.UmengManager;

/* renamed from: com.duokan.reader.domain.cloud.push.i */
class C0864i implements Runnable {
    /* renamed from: a */
    final /* synthetic */ String f4124a;
    /* renamed from: b */
    final /* synthetic */ C0863h f4125b;

    C0864i(C0863h c0863h, String str) {
        this.f4125b = c0863h;
        this.f4124a = str;
    }

    public void run() {
        if (!TextUtils.isEmpty(this.f4124a)) {
            UmengManager.get().onEvent("MIPUSH_V1", "dk_push_success");
        }
        this.f4125b.f4123a.f4122a.m5667f();
    }
}

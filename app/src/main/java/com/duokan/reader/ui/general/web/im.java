package com.duokan.reader.ui.general.web;

import com.duokan.reader.ui.account.bu;
import com.mipay.sdk.Mipay;

class im implements bu {
    /* renamed from: a */
    final /* synthetic */ il f8003a;

    im(il ilVar) {
        this.f8003a = ilVar;
    }

    /* renamed from: a */
    public void mo1844a(String str) {
        this.f8003a.f8002f.f7996b.f7581b.web_notifyWeb(this.f8003a.f7997a, 0, Mipay.KEY_RESULT, Integer.valueOf(0), "msg", str);
    }

    /* renamed from: b */
    public void mo1845b(String str) {
        this.f8003a.f8002f.f7996b.f7581b.web_notifyWeb(this.f8003a.f7997a, 2, Mipay.KEY_RESULT, Integer.valueOf(2), "msg", str);
    }

    /* renamed from: c */
    public void mo1846c(String str) {
        this.f8003a.f8002f.f7996b.f7581b.web_notifyWeb(this.f8003a.f7997a, 4, Mipay.KEY_RESULT, Integer.valueOf(4), "msg", str);
    }
}

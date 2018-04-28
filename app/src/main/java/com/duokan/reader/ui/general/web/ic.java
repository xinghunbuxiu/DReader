package com.duokan.reader.ui.general.web;

import com.duokan.reader.ui.account.bu;
import com.mipay.sdk.Mipay;

class ic implements bu {
    /* renamed from: a */
    final /* synthetic */ ib f7978a;

    ic(ib ibVar) {
        this.f7978a = ibVar;
    }

    /* renamed from: a */
    public void mo1844a(String str) {
        this.f7978a.f7977m.f7964b.f7581b.web_notifyWeb(this.f7978a.f7965a, 0, Mipay.KEY_RESULT, Integer.valueOf(0), "msg", str);
    }

    /* renamed from: b */
    public void mo1845b(String str) {
        this.f7978a.f7977m.f7964b.f7581b.web_notifyWeb(this.f7978a.f7965a, 2, Mipay.KEY_RESULT, Integer.valueOf(2), "msg", str);
    }

    /* renamed from: c */
    public void mo1846c(String str) {
        this.f7978a.f7977m.f7964b.f7581b.web_notifyWeb(this.f7978a.f7965a, 4, Mipay.KEY_RESULT, Integer.valueOf(4), "msg", str);
    }
}

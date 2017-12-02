package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ao;
import com.duokan.reader.ui.general.be;
import com.mipay.sdk.Mipay;

class hm implements ao {
    final /* synthetic */ hl a;

    hm(hl hlVar) {
        this.a = hlVar;
    }

    public void a(String str, DkCloudBookManifest dkCloudBookManifest) {
        this.a.a.a.f.b.b.web_notifyWeb(this.a.a.a.b, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            be.a(this.a.a.a.f.b.b.getContext(), (CharSequence) str2, 1).show();
        }
        this.a.a.a.f.b.b.web_notifyWeb(this.a.a.a.b, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str2);
    }
}

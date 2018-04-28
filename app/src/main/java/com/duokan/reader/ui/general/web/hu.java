package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ah;
import com.duokan.reader.ui.general.be;
import com.mipay.sdk.Mipay;

class hu implements ah {
    /* renamed from: a */
    final /* synthetic */ ht f7950a;

    hu(ht htVar) {
        this.f7950a = htVar;
    }

    /* renamed from: a */
    public void mo1047a(String str, DkCloudBookManifest dkCloudBookManifest) {
        this.f7950a.f7949a.f7944a.f7943f.f7937b.f7581b.web_notifyWeb(this.f7950a.f7949a.f7944a.f7939b, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
    }

    /* renamed from: a */
    public void mo1048a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            be.m10287a(this.f7950a.f7949a.f7944a.f7943f.f7937b.f7581b.getContext(), (CharSequence) str2, 1).show();
        }
        this.f7950a.f7949a.f7944a.f7943f.f7937b.f7581b.web_notifyWeb(this.f7950a.f7949a.f7944a.f7939b, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str2);
    }
}

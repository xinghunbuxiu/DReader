package com.duokan.reader.ui.general.web;

import android.text.TextUtils;
import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ah;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.be;
import com.mipay.sdk.Mipay;

class av implements ah {
    /* renamed from: a */
    final /* synthetic */ fp f7601a;
    /* renamed from: b */
    final /* synthetic */ String f7602b;
    /* renamed from: c */
    final /* synthetic */ StorePageController f7603c;

    av(StorePageController storePageController, fp fpVar, String str) {
        this.f7603c = storePageController;
        this.f7601a = fpVar;
        this.f7602b = str;
    }

    /* renamed from: a */
    public void mo1047a(String str, DkCloudBookManifest dkCloudBookManifest) {
        this.f7601a.m4481a(dkCloudBookManifest, FlowChargingTransferChoice.Default.wifiOnly());
        this.f7603c.web_notifyWeb(this.f7602b, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
    }

    /* renamed from: a */
    public void mo1048a(String str, String str2) {
        this.f7603c.web_notifyWeb(this.f7602b, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str2);
        if (!TextUtils.isEmpty(str2)) {
            be.m10287a(this.f7603c.getContext(), (CharSequence) str2, 1).show();
        }
    }
}

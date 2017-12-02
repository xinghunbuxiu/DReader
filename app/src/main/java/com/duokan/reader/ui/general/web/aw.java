package com.duokan.reader.ui.general.web;

import android.text.TextUtils;

import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ao;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.be;
import com.mipay.sdk.Mipay;

class aw implements ao {
    final /* synthetic */ fv a;
    final /* synthetic */ String b;
    final /* synthetic */ StorePageController c;

    aw(StorePageController storePageController, fv fvVar, String str) {
        this.c = storePageController;
        this.a = fvVar;
        this.b = str;
    }

    public void a(String str, DkCloudBookManifest dkCloudBookManifest) {
        this.a.a(dkCloudBookManifest, FlowChargingTransferChoice.Default.wifiOnly());
        this.c.web_notifyWeb(this.b, 0, Mipay.KEY_RESULT, Integer.valueOf(0));
    }

    public void a(String str, String str2) {
        this.c.web_notifyWeb(this.b, 2, Mipay.KEY_RESULT, Integer.valueOf(2), Mipay.KEY_MESSAGE, str2);
        if (!TextUtils.isEmpty(str2)) {
            be.a(this.c.getContext(), (CharSequence) str2, 1).show();
        }
    }
}

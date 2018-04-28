package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.reader.DkApp;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.fp;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ah;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.be;

final class kn implements ah {
    /* renamed from: a */
    final /* synthetic */ C0800c f8820a;

    kn(C0800c c0800c) {
        this.f8820a = c0800c;
    }

    /* renamed from: a */
    public void mo1047a(String str, DkCloudBookManifest dkCloudBookManifest) {
        ((fp) this.f8820a).m4481a(dkCloudBookManifest, FlowChargingTransferChoice.Default.wifiOnly());
    }

    /* renamed from: a */
    public void mo1048a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            be.m10287a(DkApp.get(), (CharSequence) str2, 1).show();
        }
    }
}

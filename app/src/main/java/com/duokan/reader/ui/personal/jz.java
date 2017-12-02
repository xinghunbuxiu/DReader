package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.reader.DkApp;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.fv;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ao;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.be;

final class jz implements ao {
    final /* synthetic */ c a;

    jz(c cVar) {
        this.a = cVar;
    }

    public void a(String str, DkCloudBookManifest dkCloudBookManifest) {
        ((fv) this.a).a(dkCloudBookManifest, FlowChargingTransferChoice.Default.wifiOnly());
    }

    public void a(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            be.a(DkApp.get(), (CharSequence) str2, 1).show();
        }
    }
}

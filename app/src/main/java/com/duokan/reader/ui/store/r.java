package com.duokan.reader.ui.store;

import android.content.Context;

import com.duokan.reader.DkApp;
import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.domain.cloud.ao;
import com.duokan.reader.domain.store.DkStoreBookDetail;
import com.duokan.reader.ui.bookshelf.ay;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.be;

class r implements ao {
    final /* synthetic */ al a;
    final /* synthetic */ FlowChargingTransferChoice b;
    final /* synthetic */ DkStoreBookDetail c;
    final /* synthetic */ o d;

    r(o oVar, al alVar, FlowChargingTransferChoice flowChargingTransferChoice, DkStoreBookDetail dkStoreBookDetail) {
        this.d = oVar;
        this.a = alVar;
        this.b = flowChargingTransferChoice;
        this.c = dkStoreBookDetail;
    }

    public void a(String str, DkCloudBookManifest dkCloudBookManifest) {
        Context topActivity = DkApp.get().getTopActivity();
        if (topActivity == null || topActivity.isFinishing()) {
            this.a.onDownloadCloudBookError("");
        } else if (this.b == FlowChargingTransferChoice.Default) {
            ay.a(topActivity, this.c.getEpubSize(), new s(this, dkCloudBookManifest));
        } else {
            this.d.a(this.c, dkCloudBookManifest, this.b, new u(this));
        }
    }

    public void a(String str, String str2) {
        be.a(this.d.c, (CharSequence) str2, 1).show();
        this.a.onDownloadCloudBookError(str2);
    }
}

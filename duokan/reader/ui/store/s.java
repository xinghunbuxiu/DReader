package com.duokan.reader.ui.store;

import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;

class s implements cm {
    final /* synthetic */ DkCloudBookManifest a;
    final /* synthetic */ r b;

    s(r rVar, DkCloudBookManifest dkCloudBookManifest) {
        this.b = rVar;
        this.a = dkCloudBookManifest;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            this.b.d.a(this.b.c, this.a, flowChargingTransferChoice, new t(this));
        } else {
            this.b.a.onDownloadCloudBookCanceled();
        }
    }
}

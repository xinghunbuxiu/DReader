package com.duokan.reader.ui.store;

import com.duokan.reader.domain.cloud.DkCloudBookManifest;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;

/* renamed from: com.duokan.reader.ui.store.s */
class C1506s implements cm {
    /* renamed from: a */
    final /* synthetic */ DkCloudBookManifest f11473a;
    /* renamed from: b */
    final /* synthetic */ C1505r f11474b;

    C1506s(C1505r c1505r, DkCloudBookManifest dkCloudBookManifest) {
        this.f11474b = c1505r;
        this.f11473a = dkCloudBookManifest;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            this.f11474b.f11472d.m15412a(this.f11474b.f11471c, this.f11473a, flowChargingTransferChoice, new C1507t(this));
        } else {
            this.f11474b.f11469a.onDownloadCloudBookCanceled();
        }
    }
}

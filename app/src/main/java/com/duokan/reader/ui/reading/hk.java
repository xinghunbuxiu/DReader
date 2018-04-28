package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;

class hk implements cm {
    /* renamed from: a */
    final /* synthetic */ DownloadCenterTask f10328a;
    /* renamed from: b */
    final /* synthetic */ hg f10329b;

    hk(hg hgVar, DownloadCenterTask downloadCenterTask) {
        this.f10329b = hgVar;
        this.f10328a = downloadCenterTask;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            this.f10328a.m7802p().f5036m = flowChargingTransferChoice;
            C1016b.m7857p().m7879b(this.f10328a);
            return;
        }
        this.f10329b.m14317c();
    }
}

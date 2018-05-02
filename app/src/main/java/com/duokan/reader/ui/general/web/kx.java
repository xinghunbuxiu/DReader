package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.cm;

class kx implements cm {
    /* renamed from: a */
    final /* synthetic */ DownloadCenterTask f8120a;
    /* renamed from: b */
    final /* synthetic */ TtsWebController f8121b;

    kx(TtsWebController ttsWebController, DownloadCenterTask downloadCenterTask) {
        this.f8121b = ttsWebController;
        this.f8120a = downloadCenterTask;
    }

    public void onChoice(boolean z, FlowChargingTransferChoice flowChargingTransferChoice) {
        if (z) {
            this.f8120a.m7802p().f5036m = flowChargingTransferChoice;
            this.f8121b.mDownloadCenter.m7879b(this.f8120a);
            return;
        }
        this.f8121b.mDownloadCenter.m7871a(this.f8120a);
        this.f8121b.refresh();
    }
}
